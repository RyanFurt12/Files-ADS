
public class Main {
	public static void main(String args[]) {
		Quadrado q = new Quadrado("Quadrado", 2, 10, 6);
		q.print();

		TrianguloEquilatero tr = new TrianguloEquilatero("Triangulo Equilatero", 2, 6, 6);
		tr.print();

		Cubo c = new Cubo("Cubo", 3, 4, 6, 2);
		c.print();

		Tetraedro te = new Tetraedro("Tetraedro", 3, 5, 6, 4);
		te.print();
	}
}
