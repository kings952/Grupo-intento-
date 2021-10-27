package espe.pruebas1;

public class Cuadrado extends Bidimensional {
	protected double lado;
	
	//constructor
	public Cuadrado(int codigo, String color, double lado) {
		super(codigo, color);
		this.lado = lado;
	}
	
	//getters and setters lado
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	//metodo Area
	public float Area(double lado) {
		return (float)Math.pow(lado, 2);
	}

}
