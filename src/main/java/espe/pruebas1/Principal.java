package espe.pruebas1;

public class Principal {
//prueba  de subida de datos2
	public static void main(String[] args) {
		Cuadrado figura1 = new Cuadrado (1, "Azul", 2.2);
		Esfera figura2 = new Esfera (2, "Rojo", 3.2);
		
		System.out.println("Ejemplo de herencia");
		System.out.println("CUADRADO");
		System.out.println("Codigo: "+ figura1.codigo);
		System.out.println("Color: "+figura1.color);
		System.out.println("Lado: " + figura1.lado);
		System.out.println("Area: " + figura1.Area(figura1.lado));
		
		System.out.println("\nESFERA");
		System.out.println("Codigo: "+ figura2.codigo);
		System.out.println("Color: "+figura2.color);
		System.out.println("Lado: " + figura2.radio);
		System.out.println("Area: " + figura2.Volumen(figura2.radio));
	}

}