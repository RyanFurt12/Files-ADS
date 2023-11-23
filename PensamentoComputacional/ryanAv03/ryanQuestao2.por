programa
{

	inteiro listaF[50]
	inteiro cont = 0
	
	funcao inicio()
	{
		inteiro nL1, nL2, i

		faca{
			escreva("Quantos numeros na L1: ")
			leia(nL1)		
		}enquanto(nL1<=0)
		
		faca{
			escreva("Quantos numeros na L2: ")
			leia(nL2)		
		}enquanto(nL2<=0)

		
		inteiro l1[25], l2[25]

		para (i=0; i<nL1; i++){
			escreva(i+1, "° Valor de L1: ")
			leia(l1[i])
		}
		escreva("\n")
		para (i=0; i<nL2; i++){
			escreva(i+1, "° Valor de L2: ")
			leia(l2[i])
		}
		
		mesclaLista(l1, nL1, l2, nL2)


		escreva("\n\n")
		para (i=0; i<cont; i++){
			se(i!=cont-1) escreva(listaF[i],", ")
			senao escreva(listaF[i])
		}
	}

	funcao mesclaLista( inteiro lista1[], inteiro tamanhoLista1, inteiro lista2[], inteiro tamanhoLista2){
		inteiro i=0
		cont = 0
		
		para (i=0; i<tamanhoLista1; i++){
			listaF[cont] = lista1[i]
			cont++
		}
		
		para (i=0; i<tamanhoLista2; i++){
			listaF[cont] = lista2[i]
			cont++
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 385; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */