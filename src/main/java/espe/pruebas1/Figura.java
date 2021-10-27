package espe.pruebas1;

public class Figura {
	protected int codigo;
	protected String color;
	
	//constructor
	public Figura(int codigo, String color) {
		this.codigo = codigo;
		this.color = color;
	}

	//getters and setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
