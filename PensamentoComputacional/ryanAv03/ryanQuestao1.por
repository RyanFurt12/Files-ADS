programa
{
	inclua biblioteca Texto
	
	funcao inicio()
	{
		cadeia lista[] = {" ", "Imprimir Lista no Quadro", ""}
		imprimeListaNoQuadro(lista, 3)
		
		inteiro n = 1, i
		cadeia li [5]
		
		faca{
			se(n<=0 ou n>5) escreva("Valor Invalido\n")
			escreva("\nQuantas palavras na quer lista? ")
			leia(n)
		}enquanto(n<=0 ou n>5)

		para (i=0; i<n; i++){
			faca{
				escreva("Digite a ", i+1, "º palavra: ")
				leia(li[i])
			}enquanto(li[i] == "")
		}
		
		imprimeListaNoQuadro(li, n)
	}

	funcao imprimeListaNoQuadro(cadeia lista[], inteiro flu){
		
		escreva("\n")
		se (flu>5 ou flu<1){
			escreva("Valor Invalido\n\n")
			retorne
		}
		
		inteiro nCar[5], nMaior=0, i

		para (i=0; i<flu; i++){
			nCar[i] = Texto.numero_caracteres(lista[i])
			se(nCar[i]>nMaior) nMaior = nCar[i]
		}
		nMaior += 4 

		imprimeBorda(nMaior)

		para (i=0; i<flu; i++){
			imprimePalavra(nMaior, nCar[i], lista[i])
		}

		imprimeBorda(nMaior)
	}

	funcao imprimeBorda(inteiro x){
		para (x=x; x>0;x--) escreva("*")
		escreva("\n")
	}

	funcao imprimePalavra(inteiro nT, inteiro nC, cadeia p){
		inteiro espaco = nT-2-nC, metEsp = espaco/2
		
		escreva("*")
		para (espaco = espaco; espaco>metEsp; espaco--) escreva(" ")
		escreva(p)
		para (espaco = espaco; espaco>0; espaco--) escreva(" ")
		escreva("*\n")
	}
	


}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 258; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */