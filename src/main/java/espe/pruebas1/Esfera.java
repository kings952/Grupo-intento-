package espe.pruebas1;

public class Esfera extends Tridimensional {
	protected double radio;
	
	//constructor
	public Esfera(int codigo, String color, double radio) {
		super(codigo, color);
		this.radio = radio;
	}
	
	//getters and setters radio
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	//metodo Volumen
		public float Volumen(double radio) {
			return (float)((4/3)*(Math.PI)*(Math.pow(radio, 3)));
		}
}