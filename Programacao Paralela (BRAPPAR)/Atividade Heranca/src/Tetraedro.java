
public class Tetraedro extends Tridimensional{
	public Tetraedro(String nome, int dimensao, double profundidade, double largura, double altura){
		super(nome, dimensao, profundidade, largura, altura);

		double alturaEsperada = (Math.sqrt(6) / 3) * largura;
		double profundidadeEsperada = (Math.sqrt(3) / 2) * largura;

		if(profundidade != profundidadeEsperada){
			this.setProfundidade(profundidadeEsperada);
			System.out.println("\nDimensões erradas, equalizando profundidade para: " + profundidadeEsperada);
		} 
		if(altura != alturaEsperada){
			this.setAltura(alturaEsperada);
			System.out.println("\nDimensões erradas, equalizando altura para: " + alturaEsperada);
		}
	}

	@Override
	public double area(){
		return Math.sqrt(3) * this.getLargura() * this.getLargura();
	}

	@Override
	public double volume(){
		return (Math.sqrt(2) / 12) * this.getLargura() * this.getLargura() * this.getLargura();
	}

	@Override
    public String toString() {
        return super.toString() + "\nArea: " + this.area() + "\nVolume: " + this.volume();
    }

	public void print(){
		System.out.println(this.toString());
	}
}