from datetime import datetime
from random import randint

import pytz


class ContaCorrente:
    """
    Classe para gerenciar as contas-correntes
    """
    @staticmethod
    def _data_hora():
        fuso_br = pytz.timezone('Brazil/East')
        horario_br = datetime.now(fuso_br)
        return horario_br.strftime('%d/%m/%y %H:%M:%S')

    def __init__(self, nome: str, cpf: str, agencia: str, num_conta: str):
        self.nome = nome
        self.cpf = cpf
        self.__saldo = 0.0
        self.__limite = None
        self.agencia = agencia
        self.num_conta = num_conta
        self.transacoes = []
        self.cartoes = []

    def consultar_saldo(self):
        print("Seu Saldo Atual é de R${:,.2f}".format(self.__saldo))

    def depositar_dinheiro(self, valor):
        self.__saldo += valor
        self.transacoes.append(("Deposito", valor, self.__saldo, self._data_hora()))

    def sacar_dinheiro(self, valor):
        # if self.saldo - valor < 0:
        if self.__saldo - valor < self.__limite_conta():
            print('Você não tem saldo suficiente para sacar este valor')
            self.consultar_saldo()
        else:
            self.__saldo -= valor
            self.transacoes.append(("Saque", -valor, self.__saldo, self._data_hora()))

    def __limite_conta(self):
        self.__limite = -1000
        return self.__limite

    def consultar_historico_transacoes(self):
        print("Histórico de Transações: ")
        for transacao in self.transacoes:
            print(transacao)

    def transferir(self, valor, conta_destino):
        self.__saldo -= valor
        self.transacoes.append(("Envio", -valor, self.__saldo, self._data_hora()))
        conta_destino.__saldo += valor
        conta_destino.transacoes.append(("Recebido", valor, conta_destino.__saldo, self._data_hora()))


class CartaoCredito:
    @staticmethod
    def _data_hora():
        fuso_br = pytz.timezone('Brazil/East')
        horario_br = datetime.now(fuso_br)
        return horario_br.strftime('%d/%m/%y %H:%M:%S')

    def __init__(self, titular: str, conta_corrente: ContaCorrente):
        self.numero = randint(1000000000, 9999999999)
        self.titular = titular
        self.validade = f"{datetime.now().month}/{str(datetime.now().year+4)[-2:]}"
        self.cod_seguranca = f"{randint(0,9)}{randint(0,9)}{randint(0,9)}"
        self.limite = 1000
        self._senha = '1234'
        self.conta_corrente = conta_corrente
        conta_corrente.cartoes.append(self)

    @property
    def senha(self):
        return self._senha

    @senha.setter
    def senha(self, nova_senha):
        if len(nova_senha) == 4 and nova_senha.isnumeric():
            self._senha = nova_senha
        else:
            print("Nova senha invalida!")
