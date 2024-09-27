
public class Cubo extends Tridimensional{
	public Cubo(String nome, int dimensao, double profundidade, double largura, double altura){
		super(nome, dimensao, profundidade, largura, altura);
		if(profundidade != largura || altura != largura){
			this.setProfundidade(largura);
			this.setAltura(largura);
			System.out.println("\n\nDimensões erradas, equalizando para: " + largura);
		}
	}

	@Override
	public double area(){
		return 4 * this.getLargura() * this.getLargura();
	}

	@Override
	public double volume(){
		return this.getProfundidade() * this.getLargura() * this.getAltura();
	}

	@Override
    public String toString() {
        return super.toString() + "\nArea: " + this.area() + "\nVolume: " + this.volume();
    }

	public void print(){
		System.out.println(this.toString());
	}
}