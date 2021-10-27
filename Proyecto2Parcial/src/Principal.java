import java.util.Scanner;
import java.io.*;
public class Principal {
	
	public static void main(String[] args) throws IOException{
		int opcion, opc1
		;
		Scanner Entrada = new Scanner(System.in);
		Mascota lista1 = new Mascota();
		Veterinario lista2 = new Veterinario();
		Diagnostico lista3 = new Diagnostico();
		
		lista1.leerLista();
		lista2.leerLista();
		lista3.leerLista();
		
		do {	
			System.out.println("PROYECTO JAVA - VETERINARIA");
			System.out.println("1. Mascota");
			System.out.println("2. Veterinario");
			System.out.println("3. Diagnostico");
			System.out.println("0. Salir");
			System.out.println("\nEscoja la clase a trabajar: ");
			opcion = Entrada.nextInt();
			switch(opcion) {
				case 0:
					System.out.println("PROGRAMA FINALIZADO");
					new java.util.Scanner(System.in).nextLine();
					break;
				
				case 1:
					//menu de mascotas
					do {
						limpiarConsola(50);
						lista1.mostrarLista();
						System.out.println("MASCOTAS");
						System.out.println("0. Regresar al menu");
						System.out.println("1. Nuevo Registro");
						System.out.println("2. Actualizar Registro");
						System.out.println("3. Eliminar Registro");
						System.out.println("4. Buscar Registro");
						System.out.println("\nEscoja la opcion a trabajar: ");
						opc1 = Entrada.nextInt();
						switch(opc1) {
						case 0:
							break;
						case 1:
							lista1.insertarLista();
							lista1.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;		
						case 2:
							lista1.modificarNodo();
							lista1.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						case 3:
							lista1.eliminarNodo();
							lista1.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						case 4:
							lista1.buscarRegistro();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						default:
							System.out.println("Error: ingrese valores entre 0 y 3");
							new java.util.Scanner(System.in).nextLine();
						}
					}while(opc1 != 0);
				
					System.out.println("Presione una tecla para continuar ...");
					new java.util.Scanner(System.in).nextLine();
					break;
				
				case 2:
					//menu de veterinario
					do {
						limpiarConsola(50);
						lista2.mostrarLista();
						System.out.println("VETERINARIO");
						System.out.println("0. Regresar al menu");
						System.out.println("1. Nuevo Registro");
						System.out.println("2. Actualizar Registro");
						System.out.println("3. Eliminar Registro");
						System.out.println("4. Buscar Registro");
						System.out.println("\nEscoja la opcion a trabajar: ");
						opc1 = Entrada.nextInt();
						switch(opc1) {
						case 0:
							break;
						case 1:
							lista2.insertarLista();
							lista2.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;		
						case 2:
							lista2.modificarNodo();
							lista2.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						case 3:
							lista2.eliminarNodo();
							lista2.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						case 4:
							lista2.buscarRegistro();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						default:
							System.out.println("Error: ingrese valores entre 0 y 3");
							new java.util.Scanner(System.in).nextLine();
						}
					}while(opc1 != 0);
					System.out.println("Presione una tecla para continuar ...");
					new java.util.Scanner(System.in).nextLine();
					break;
				
				case 3:
					//menu de veterinario
					do {
						limpiarConsola(50);
						lista3.mostrarLista(lista1, lista2);
						System.out.println("DIAGNOSTICO");
						System.out.println("0. Regresar al menu");
						System.out.println("1. Nuevo Registro");
						System.out.println("2. Actualizar Registro");
						System.out.println("3. Borrar Registro");
						System.out.println("4. Buscar Registro");
						System.out.println("\nEscoja la opcion a trabajar: ");
						opc1 = Entrada.nextInt();
						switch(opc1) {
						case 0:
							break;
						case 1:
							lista3.insertarLista(lista1, lista2);
							lista3.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;		
						case 2:
							lista3.modificarNodo(lista1, lista2);
							lista3.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						case 3:
							lista3.eliminarNodo(lista1, lista2);
							lista3.guardarLista();
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						case 4:
							lista3.buscarRegistro(lista1, lista2);
							System.out.println("Presione una tecla para continuar ...");
							new java.util.Scanner(System.in).nextLine();
							break;
						default:
							System.out.println("Error: ingrese valores entre 0 y 3");
							new java.util.Scanner(System.in).nextLine();
						}
					}while(opc1 != 0);
					
					System.out.println("Presione una tecla para continuar ...");
					new java.util.Scanner(System.in).nextLine();
					break;
				
				default:
					System.out.println("Error: ingrese valores entre 0 y 3");
					new java.util.Scanner(System.in).nextLine();
			}
			limpiarConsola(50);
		}while(opcion != 0);
		
	}
	
	//procedimiento limpiar consola
	public static void limpiarConsola(int lineas)
	{
	 for (int i=0; i < lineas; i++)
		 System.out.println();
	}
}
