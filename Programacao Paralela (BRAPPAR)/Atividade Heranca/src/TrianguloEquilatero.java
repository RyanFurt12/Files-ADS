
public class TrianguloEquilatero extends Bidimensional{
	public TrianguloEquilatero(String nome, int dimensao, double comprimento, double largura){
		super(nome, dimensao, comprimento, largura);
		double larguraEsperada = (Math.sqrt(3) / 2) * comprimento;
		if(altura != larguraEsperada){
			this.setLargura(larguraEsperada);
			System.out.println("\n\nValor de largura/altura errada, equalizando para: " + largura);
		}
	}

	@Override
	public double area(){
		return (this.largura * this.comprimento) / 2;
	}

	@Override
    public String toString() {
        return super.toString() + "\nÁrea: " + this.area();
    }

    public void print() {
        System.out.println(this.toString());
    }
}