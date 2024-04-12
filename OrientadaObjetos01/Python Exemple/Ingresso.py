valorTotal = 0
while True:
    idade = int(input("Qual sua idade? (0 para sair) "))
    if idade == 0:
        print("\nSaindo...")
        break
    if idade < 5:
        print("Entrada gratuita!")
        continue
    valor = 12 if idade <= 12 else 24
    valorTotal += valor
    print("Valor desse ingresso é R$%.2f" % valor)

print("O total da compra é R$%.2f" % valorTotal)
