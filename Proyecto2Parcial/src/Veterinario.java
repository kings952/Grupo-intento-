import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Veterinario {
	
	//subclase objeto Veterinario
	protected class ObjetoVeterinario{
		private String codigoV;
		private String nombre;
		
		//constructor
		public ObjetoVeterinario(String codigoV, String nombre) {
			this.codigoV = codigoV;
			this.nombre = nombre;
		}

		public String getCodigoV() {
			return codigoV;
		}

		public void setCodigoV(String codigoV) {
			this.codigoV = codigoV;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}
	
	protected ArrayList<ObjetoVeterinario> listaVeterinario;
	private Scanner Entrada;
	
	//constructor arraylist
	public Veterinario() {
		listaVeterinario = new ArrayList<ObjetoVeterinario>();
		Entrada = new Scanner (System.in);
	}
	
	//metodo Create
	public void insertarLista(){ 
		
		ObjetoVeterinario auxiliar = new ObjetoVeterinario(null, null);
		boolean bandera = false;
		
		//ingreso de datos en ObjetoVeterinario
		System.out.println("INGRESE LOS DATOS SOLICITADOS PARA VETERINARIO:");
		
		do {
			System.out.print("Cédula: ");
			auxiliar.setCodigoV(Entrada.nextLine());
			bandera = compararCodigo(auxiliar.getCodigoV());
		}while (bandera);
		
		System.out.print("Cedula dueño: ");
		auxiliar.setNombre(Entrada.nextLine());
		
		listaVeterinario.add(auxiliar);
	}
	
	//metodo Read
	public void mostrarLista() {
		
		ObjetoVeterinario auxiliar = new ObjetoVeterinario(null, null);
		int num=0;
		
		System.out.println("====================================");
		System.out.println("|| Cédula  |  Nombre Veterinario  ||");
		System.out.println("====================================");
		while(num != listaVeterinario.size()) {
			auxiliar = listaVeterinario.get(num);
			System.out.print((num+1)+"\t"+auxiliar.getCodigoV()+"\t"+auxiliar.getNombre()+"\n");
			num++;
		}
		System.out.println("=====================================");
		
	}
	
	//metodo update
	public void modificarNodo() {
		int aux;
		String cod;
		boolean bandera = false;
		ObjetoVeterinario auxiliar = new ObjetoVeterinario(null, null);
		
		do {
			System.out.println("Ingrese el codigo de Veterinario a modificar: ");
			cod = Entrada.nextLine();
			bandera = compararCodigo(cod);
		}while(!bandera);
		aux = obtenerIndice(cod);
		
		System.out.println("INGRESE LOS DATOS SOLICITADOS PARA VETERINARIO:");
		do {
			System.out.print("Código: ");
			auxiliar.setCodigoV(Entrada.nextLine());
			bandera = compararCodigo(auxiliar.getCodigoV());
			if(cod == auxiliar.getCodigoV()) {
				bandera = false;
			}
		}while (bandera);
		System.out.print("Cedula Veterinario: ");
		auxiliar.setNombre(Entrada.nextLine());
		
		listaVeterinario.remove(aux-1);
		listaVeterinario.add(aux-1,auxiliar);
		System.out.println("NODO ACTUALIZADO");
	}
	
	// metodo borrar
	public void eliminarNodo() {
		int aux;
		String cod;
		boolean bandera;
		do {
			System.out.println("Ingrese el codigo de Veterinario a modificar: ");
			cod = Entrada.nextLine();
			bandera = compararCodigo(cod);
		}while(!bandera);
		
		aux = obtenerIndice(cod);
		listaVeterinario.remove(aux-1);
		System.out.println("El nodo se ha eliminado con exito!");
	}
	
	// lectura archivo
	public void leerLista() {
		
		listaVeterinario.clear();
		
		try {
            File archivo = new File("Veterinario.txt");
            if (archivo.exists()) {
                FileReader lector = new FileReader(archivo);
				BufferedReader linea = new BufferedReader(lector);
                String aux;
                while ((aux = linea.readLine()) != null) {
                	ObjetoVeterinario auxiliar = new ObjetoVeterinario(null, null);
                    String[] cadena = aux.split(" ");
           
                    auxiliar.setCodigoV(cadena[0]);
                    auxiliar.setNombre(cadena[1]);
                    
                    listaVeterinario.add(auxiliar);
                    
                }
                linea.close();
                lector.close();
            } else {
            	System.out.println("EL ARCHIVO ESTÁ VACÍO");
            }
            
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	public void guardarLista() throws IOException{ 
		
		ObjetoVeterinario auxiliar = new ObjetoVeterinario(null, null);
		
		try {
			File archivo = new File("Veterinario.txt");
			FileWriter lector;
			BufferedWriter linea;
			
			lector = new FileWriter(archivo);
			linea = new BufferedWriter(lector);
			for(int i = 0; i < listaVeterinario.size(); i++) {
				auxiliar = listaVeterinario.get(i);
				if(i==listaVeterinario.size()-1) {
					linea.write(auxiliar.getCodigoV() + " " + auxiliar.getNombre());
				}else {
					linea.write(auxiliar.getCodigoV() + " " + auxiliar.getNombre()+"\n");
				}
			}
			linea.close();
			lector.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	// metodo buscar registro
	public void buscarRegistro() {
		String aux;
		int num=0;
		boolean band=false;
		ObjetoVeterinario auxiliar = new ObjetoVeterinario(null, null);
		
		System.out.println("Escoja el codigo de la Veterinario asignado:");
		aux = Entrada.nextLine();
		
		while(num != listaVeterinario.size()) {
			auxiliar = listaVeterinario.get(num);
			if(aux == auxiliar.getCodigoV()) {
				band = true;
				break;
			}
			num++;
		}
		
		if(band == true) {
			System.out.println("====================================");
			System.out.println("|| Cédula 	|  Nombre Veterinario  ||");
			System.out.println("====================================");
			System.out.print(auxiliar.getCodigoV()+"\t"+auxiliar.getNombre());
		}else {
			System.out.println("La Veterinario no se encuentra registrada.");
		}
		System.out.println("========================================");
	}
	
	// metodo comparar codigo
	public boolean  compararCodigo(String codigo){
		boolean codigoEncontrado = false;
		try {
            File archivo = new File("Veterinario.txt");
            if (archivo.exists()) {
                FileReader lector = new FileReader(archivo);
				BufferedReader linea = new BufferedReader(lector);
                String aux;
                while ((aux = linea.readLine()) != null) {
                	
                    String[] cadena = aux.split(" ");
                    
                    if(codigo.equals(cadena[0])) {
                    	System.out.println("Existe Veterinario con ese código");
                    	codigoEncontrado = true;
                    	break;
                    }  
                }
                linea.close();
                lector.close();
            } else {
            	System.out.println("EL ARCHIVO ESTÁ VACÍO");
            }
            
		} catch (Exception e) {
			System.out.println(e);
		}
		return codigoEncontrado;
	}
	
	//metodo obtener indice
	public int obtenerIndice(String cod) {
		int aux=0, num=0;
		while(num != listaVeterinario.size()){
			if(cod.equals(listaVeterinario.get(num).getCodigoV())) {
				aux = num+1;
				break;
			}
			num++;
		}
		return aux;
	}
}
