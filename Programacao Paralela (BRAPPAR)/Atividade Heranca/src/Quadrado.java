
public class Quadrado extends Bidimensional{
	public Quadrado(String nome, int dimensao, double comprimento, double largura){
		super(nome, dimensao, comprimento, largura);
		if(comprimento != largura){
			this.setComprimento(largura);
			System.out.println("\n\nValor de comprimento e largura diferentes, equalizando ambos para: " + largura);
		}
	}

	@Override
	public double area(){
		return this.getComprimento() * this.getLargura();
	}
}
