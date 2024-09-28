
public class TrianguloEquilatero extends Bidimensional{
	public TrianguloEquilatero(String nome, int dimensao, double comprimento, double largura){
		super(nome, dimensao, comprimento, largura);
		double larguraEsperada = (Math.sqrt(3) / 2) * comprimento;
		if(largura != larguraEsperada){
			this.setLargura(larguraEsperada);
			System.out.println("\n\nValor de largura/altura errada, equalizando para: " + larguraEsperada);
		}
	}

	@Override
	public double area(){
		return (this.getLargura() * this.getComprimento()) / 2;
	}

	@Override
    public String toString() {
        return super.toString() + "\nÁrea: " + this.area();
    }

    public void print() {
        System.out.println(this.toString());
    }

	@Override
	public double getAltura() {
		return 0;
	}
}