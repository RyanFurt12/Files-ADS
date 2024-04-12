def exercicio01():
  # 1- Faça um Programa que leia uma lista de 10 caracteres, e diga quantas consoantes 
  # foram lidas. Imprima as consoantes.
  def listar_consoantes(lista_de_letras):
      consoantes = []
      todas_vogais = ['a', 'e', 'i', 'o', 'u']
      for letra in lista_de_letras:
          if letra not in todas_vogais:
            consoantes.append(letra)
      return consoantes

  print("//Recebe 10 caracteres, e retorna a quantidade de consoantes\n")
  lista = []
  for i in range(10):
      letra = input(f"Digite a {i+1}ª letra: ")[0]
      lista.append(letra)
    
  lista_consoantes = listar_consoantes(lista)
  print(f"São {len(lista_consoantes)} consoantes, sendo:\n{lista_consoantes}")
  finalizacao()

  
def exercicio02():
  # 2- Faça um programa que receba a temperatura média de cada mês do ano e armazene-as
  # em uma lista. Após isto, calcule a média anual das temperaturas e mostre todas as 
  # temperaturas acima da média anual, e em que mês elas ocorreram (mostrar o mês por 
  # extenso: 1 – Janeiro, 2 – Fevereiro, . .).
  #
  print("//Recebe a temperatura média de cada mês e realiza calculos\n")
  meses = ['Janeiro', 'Fevereiro', 'Março', 'Abril',
           'Maio', 'Junho', 'Julho', 'Agosto',
           'Setembro', 'Outubro', 'Novembro', 'Dezembro']
  temperaturas_medias = []
  
  for mes in meses:
      temperaturas_medias.append(
        float(input(f"Qual a temperatura mêdia do mês {mes}? "))
      )
  
  temperatura_media_ano = sum(temperaturas_medias) / len(temperaturas_medias)
  print("======================")
  print(f"A média anual foi de { round(temperatura_media_ano, 2) }°C")
  print("======================")
  
  print("Sendo:")
  for i in range(len(meses)):
      mes = meses[i]
      temperatura = temperaturas_medias[i]
      print(round(temperatura, 2), "°C em ", mes, sep='')
  finalizacao()

  
def exercicio03():
  # 3 - Faça um Programa que peça as quatro notas de 10 alunos, calcule e armazene numa 
  # lista a média de cada aluno, imprima o número de alunos com média maior ou igual a
  # 7.0. alunos com media maior que 7.0 ---> ", somaAlunos)
  # # 
  print("//Recebe as notas de 10 alunos e retorna a média de cada um\n")
  notas_alunos = []
  soma_alunos_aprovados = 0
  
  for i in range(10):
      notas = []
      for j in range(4):
          notas.append(float(input(f"Digite a nota {j+1} do aluno {i+1}: ")))
      notas_alunos.append({ 'nota': notas, 'media': sum(notas) / len(notas) })
  
      if notas_alunos[i]['media'] >= 7:
          soma_alunos_aprovados += 1
        
      print(notas_alunos[i], "\n")
    
  print(f"Alunos com média maior ou igual a 7 --> {soma_alunos_aprovados}")
  finalizacao()


def exercicio04():
  # 4- Faça um programa que leia um número indeterminado de valores, correspondentes a 
  # notas, encerrando a entrada de dados quando for informado um valor igual a -1 (que 
  # não deve ser armazenado). Após esta entrada de dados, faça:
    # 1. Mostre a quantidade de valores que foram lidos;
    # 2. Exiba todos os valores na ordem em que foram informados, um ao lado do outro;
    # 3. Exiba todos os valores na ordem inversa à que foram informados, um abaixo do
    # outro;
    # 4. Calcule e mostre a soma dos valores;
    # 5. Calcule e mostre a média dos valores;
  print("//Recebe notas e retorna informações sobre elas\n")
  notas = []
  while True:
      nota = float(input("Digite uma nota: "))
      if nota == -1:
          break
      notas.append(nota)
  soma_notas = sum(notas)
  print(f"\n1- Foram lidas {len(notas)} notas")
  print("2- ", notas)
  for nota in notas[::-1]:
      print("3- ", nota)
  print(f"4- A soma das notas é {soma_notas}")
  print(f"5- A média das notas é {soma_notas / len(notas)}")
  finalizacao()

  
def exercicio05():
  # 5º) Em uma competição de salto em distância cada atleta tem direito a cinco saltos. 
  # O resultado do atleta será determinado pela média dos cinco valores restantes. Você
  # deve fazer um programa que receba o nome e as cinco distâncias alcançadas pelo 
  # atleta em seus saltos e depois informe o nome, os saltos e a média dos saltos. O 
  # programa deve ser encerrado quando não for informado o nome do atleta.
  ordenacao = ['Primeiro', 'Segundo', 'Terceiro', 'Quarto', 'Quinto']
  print("//Recebe informações dos saltos de um atleta, e retorna dados\n")

  nome = input("Digite o nome do atleta: ")
  saltos = []
  
  for i in range(5):
      saltos.append(float(input(f"Digite o {ordenacao[i]} salto: ")))
    
  print("\nResultado final:")
  print(f"Atleta: {nome}")
  print(f"Saltos: {saltos}")
  print(f"Média dos saltos: {round(sum(saltos) / len(saltos), 1)} m")
  finalizacao()


def exercicio06():
  # 6º) Foram anotadas as idades e alturas de 7 alunos. Faça um Programa que determine 
  # quantos alunos com mais de 13 anos possuem altura inferior à média de altura desses
  # alunos.
  print("//Retorna dados informações dos alunos\n")
  idades = [14, 12, 13, 16, 18, 20, 13]
  alturas = [1.8, 1.9, 1.0, 2.0, 1.4, 1.3, 1.85]
  soma_alturas = 0
  
  for i in range(len(alturas)):
      soma_alturas += alturas[i]
    
  media_alturas = soma_alturas / len(alturas)
  mais_de_13_anos_baixo = sum(1 for index, idade in enumerate(idades) 
                              if idade > 13 and alturas[index]<media_alturas)
  print(f"A média das alturas é {round(media_alturas, 2)}")
  print(f"{mais_de_13_anos_baixo} Alunos com mais de 13 anos e baixos, sendo eles:")
  for i in range(len(idades)):
      if idades[i] > 13 and alturas[i] < media_alturas:
          print(f"  Aluno {i+1}: {alturas[i]} m")
  finalizacao()


def exercicio07():
  # 7- Você foi contratado para desenvolver um programa que leia o resultado da
  # enquete e informe ao final o resultado da mesma. O programa deverá ler os valores
  # até ser informado o valor 0, que encerra a entrada dos dados. Não deverão ser 
  # aceitos valores além dos válidos para o programa (1 a 6). Os valores referentes a 
  # cada uma das opções devem ser armazenados numa lista. Após os dados terem sido 
  # completamente informados, o programa deverá calcular a percentual de cada um dos
  # concorrentes e informar o vencedor da enquete.
  print("//Recebe os votos da enquete e retorna o resultado\n")
  candidatos = [
      {"nome": "Ricardo Nunes (MDB)", "votos": 0},
      {"nome": "Guilherme Boulos (PSOL)", "votos": 0},
      {"nome": "Tabata Amaral (PSB)", "votos": 0},
      {"nome": "Kim Kataguiri (UNIÃO)", "votos": 0},
      {"nome": "Maria Helena (NOVO)", "votos": 0},
      {"nome": "Altino Prazeres (PSTU)", "votos": 0}
  ]
  opcao = 21

  while opcao != 0:
    for index, candidato in enumerate(candidatos):
      print(f"{index+1} - {candidato['nome']}")
    print('0- Sair\n')

    try:
      opcao = int(input("Insira uma opcao: "))
    except ValueError:
      opcao = 21

    if opcao != 0:
      if opcao >= 1 and opcao <= 6:
        candidatos[opcao-1]['votos'] += 1        
      else:
        print('Opção inválida! Tente novamente')
      finalizacao()
    limpar_console()

    
  total_votos = sum(candidato['votos'] for candidato in candidatos)
  if total_votos == 0:
    print("Finalizando programa... Não houve votos")
    return
    
  print("Candidato Votos %")
  print("---------------------------")
  for candidato in candidatos:
    print(f"{candidato['nome']} - {candidato['votos']} -",
      f"{round(candidato['votos'] / total_votos * 100, 2)}%")
  print("---------------------------")
  print(f"Total - {total_votos} - 100%")
  
  index_mais_votado = 0
  for index, candidato in enumerate(candidatos):
    if candidato['votos'] > candidatos[index_mais_votado]['votos']:
      index_mais_votado = index
  print(f"O candidato mais votado foi {candidatos[index_mais_votado]['nome']}",
       f"com {candidatos[index_mais_votado]['votos']} votos, correspondendo a",
       f"{round(candidatos[index_mais_votado]['votos'] / total_votos* 100, 2)}%",
       "dos votos.")
  
  finalizacao()


def exercicio08():
  # 8º) Utilize uma lista para resolver o problema a seguir. Uma empresa paga seus 
  # vendedores com base em comissões. O vendedor recebe $200 por semana mais 9 por cento 
  # de suas vendas brutas daquela semana. Escreva um programa (usando uma lista de
  # contadores) que determine quantos vendedores receberam salários nos seguintes 
  # intervalos de valores:
  print("//Recebe os valores das vendas e retorna o salário\n")

  vendas = [200, 300, 400, 800, 900, 1000, 2000, 3000, 4000, 5000, 6000, 8000, 15000]
  intervalos_min = [200, 300, 400, 500, 600, 700, 800, 900, 1000]
  salarios = []
  contadores = [0]*len(intervalos_min)
  
  for venda in vendas:
    salario = 200 + (venda * 0.09)
    salarios.append(salario)

    for i, intervalo in enumerate(intervalos_min):
      proximo = float('inf') if i == (len(intervalos_min)-1) else intervalos_min[i+1]
      if salario >= intervalo and salario < proximo:
        contadores[i] += 1
        break
             
  print("Intervalo de vendas - Contador")
  for i in range(len(intervalos_min)):
    proximo = "inf" if i == len(intervalos_min)-1 else intervalos_min[i+1]-1
    print(f"${intervalos_min[i]} - ${proximo}: {contadores[i]} vendedores")
    
  finalizacao()
  

def exercicio09():
  # 9º) Uma grande emissora de televisão quer fazer uma enquete entre os seus 
  # telespectadores para saber qual o melhor jogador após cada jogo. Para isto, faz-se
  # necessário o desenvolvimento de um programa, que será utilizado pelas telefonistas, 
  # para a computação dos votos. Sua equipe foi contratada para desenvolver este programa,
  # utilizando a linguagem de programação Python. Para computar cada voto, a telefonista
  # digitará um número, entre 1 e 23, correspondente ao número da camisa do jogador. Um 
  # número de jogador igual zero, indica que a votação foi encerrada. Se um número 
  # inválido for digitado, o programa deve ignorá-lo, mostrando uma breve mensagem de 
  # aviso, e voltando a pedir outro número. Após o final da votação, o programa deverá 
  # exibir:

  def calcular_percentual(votos, total):
    return round((votos / total) * 100, 2) if total > 0 else 0
  
  print("//Recebe os votos e retorna o resultado\n")
  jogadores_votos = [0]*23
  
  while True:
    try:
      voto = int(input("Digite o número de 1 a 23 (0 para sair): "))
    except ValueError:
      print("Valor inválido! Tente novamente.")
      continue
      
    if voto == 0:
      break
      
    elif voto < 1 or voto > 23:
      print("Valor inválido! Tente novamente.")
    else:
      jogadores_votos[voto-1] += 1
      
  limpar_console()
  
  total_votos = sum(jogadores_votos)
  
  print("//Recebe os votos e retorna o resultado\n")
  print("= Resultado da Votação =")
  print("Foram computados", total_votos, "votos, sendo:\n")
  
  for i in range(len(jogadores_votos)):
    if jogadores_votos[i] > 0:
      print(f"Jogador {i+1}: {jogadores_votos[i]} voto(s) sendo",
            f"{calcular_percentual(jogadores_votos[i], total_votos)}%")

  melhor_jogador = jogadores_votos.index(max(jogadores_votos))
  print(f"\nO melhor jogador foi o número {melhor_jogador+1} com",
        f"{jogadores_votos[melhor_jogador]} voto(s)")

  finalizacao()

# Utils
def finalizacao():
  input("Pressione enter para continuar...")


def limpar_console():
  print('\033[H\033[J')


# Menu
while True:
  limpar_console()
  print("Ryan Furtado de Almeida   BP3044165")
  print("Lista de Exercicios 1 - POO")
  print("===========================")
  for i in range(9):
    print(i+1,"- Exercicio",i+1)
  print("0 - Sair")
  print("===========================")
  
  try:
    opcao = int(input("Digite o numero do exercicio: "))
  except ValueError:
    print("Opcao invalida!")
    continue
    
  limpar_console()
  if opcao == 0:
    break
  elif opcao == 1:
    exercicio01()
  elif opcao == 2:
    exercicio02()
  elif opcao == 3:
    exercicio03()
  elif opcao == 4:
    exercicio04()
  elif opcao == 5:
    exercicio05()
  elif opcao == 6:
    exercicio06()
  elif opcao == 7:
    exercicio07()
  elif opcao == 8:
    exercicio08()
  elif opcao == 9:
    exercicio09()