import datetime

# Um funcionário de uma empresa recebe aumento salarial anualmente, sabe-se que:
# a) Esse funcionário foi contratado em 2020, com determinado salário inicial;
# b) Em 2021 recebeu aumento de 0,5% sob seu salário;
# c) A partir de 2022 (inclusive), os aumentos salariais sempre corresponderam a 50% a mais do percentual anterior.
# Faça um programa que determine o salário atual do funcionário;

salarioInicial = float(input("Qual o salario inicial? "))
anoDeEntrada = int(input("Qual o ano de entrada na empresa? "))
percentual = .5/100
anoAtual = datetime.date.today().year
anoTemp = anoDeEntrada
salario = salarioInicial

while anoTemp < anoAtual:
    anoTemp += 1
    if anoTemp >= 2022:
        percentual = percentual * 1.5
    salario *= (percentual+1)

if anoDeEntrada >= anoAtual:
    print("Xo, vai ficar no inicial R$%.2f" % salario)
else:
    print(f"Seu salario no ano {anoTemp} é de %.2f" % salario)
