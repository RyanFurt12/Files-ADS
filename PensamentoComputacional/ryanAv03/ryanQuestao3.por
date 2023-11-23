programa
{
	caracter matriz[][] = {{ {'-', '-', '-', '-'},
						{'-', '-', '-', '-'},
						{'-', '-', '-', '-'} }
						
	constante inteiro mX = 4, mY = 3
						
	funcao inicio(){

		inteiro x=0, y=0
		caracter op = 's'

		drawMatriz()
		faca{
			
			escreva("\nDeseja marcar uma coordenada (s|n)? ")
			leia(op)
			

			
			se(op == 's' ou op == 'S'){
				faca{
					escreva("x: ")
					leia(x)				
				}enquanto(x<=0 ou x>mX)
			
				faca{
					escreva("y: ")
					leia(y)				
				}enquanto(y<=0 ou y>mY)

				marcarMatriz(x,y)
			}
			
			
			drawMatriz()
		}enquanto (op == 's' ou op == 'S')
	}

	funcao drawMatriz(){
		inteiro i, j

		escreva("\n")
		
		para (i=0; i<mY; i++){
			para (j=0; j<mX; j++)escreva(matriz[i][j])
			escreva("\n")
		}
	}

	funcao marcarMatriz(inteiro x, inteiro y){

		x-=1
		y-=1
		
		se(matriz[y][x] == 'M'){
			escreva("Area já foi demarcada, tente outro valor\n")
			retorne
		}
		
		escreva("Demarcando em ",x+1,", ",y+1,"...\n")
		matriz[y][x] = 'M'
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 958; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */