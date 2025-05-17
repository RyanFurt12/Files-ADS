import requests

def a():
    try:
        ip_address = input("Digite um IP: ")
        list = [int(a) for a in ip_address.split('.')]
    except:
        print('valor invalido')
        return

    isValid = len(list) == 4
    if(isValid): 
        for x in list: 
            isValid = isValid and (0 <= x and x <= 255)
        
    if(not isValid):
        print("IP invalido")
        return

    ipClass = "Classe " + (
        "A" if list[0]<127 else 
        "B" if list[0]<192 else 
        "C" if list[0]<224 else 
        "D" if list[0]<240 else 
        "E" if list[0]<248 else 
        "Invalido"
    )
    
    url = f'https://ipinfo.io/{ip_address}/json'
    response = requests.get(url)
    data = response.json()

    city = data.get('city', 'Cidade não encontrado')
    region = data.get('region', 'Estado não encontrado')
    country = data.get('country', 'Pais não encontrado')

    print(f'{ip_address}, ip da {ipClass}')
    print("local: ", city, " - ", region, " - ", country)

a()