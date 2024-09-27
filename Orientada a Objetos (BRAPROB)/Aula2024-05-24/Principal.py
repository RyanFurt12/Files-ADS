from Agencia import ContaCorrente, CartaoCredito

conta_jose = ContaCorrente('José', '123.456.789-10', '0115', '123456')

# print("Cliente = ", conta_jose.nome)
# print("CPF: ", conta_jose.cpf)
# print("Agencia: ", conta_jose.agencia)
# print("Número da Conta: ", conta_jose.num_conta)
# print("Saldo: ", conta_jose.__saldo)

conta_jose.depositar_dinheiro(2000)
conta_jose.sacar_dinheiro(450)

conta_zeca = ContaCorrente('Zeca', '111.222.333-44', '0120', '654321')
conta_jose.transferir(500, conta_zeca)

cartao_jose = CartaoCredito("José", conta_jose)

print(cartao_jose.__dict__)
