import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mascota {
	
	//subclase objeto mascota
	protected class ObjetoMascota{
		private int codigoM;
		private String cedula;
		private String nombreCliente;
		private String nombreMascota;
		private int edadMascota;
		private String tipo;
		
		//constructor
		public ObjetoMascota(int codigoM, String cedula, String nombreCliente, String nombreMascota, int edadMascota,
				String tipo) {

			this.codigoM = codigoM;
			this.cedula = cedula;
			this.nombreCliente = nombreCliente;
			this.nombreMascota = nombreMascota;
			this.edadMascota = edadMascota;
			this.tipo = tipo;
		}
		
		public int getCodigoM() {
			return codigoM;
		}
		public void setCodigoM(int codigoM) {
			this.codigoM = codigoM;
		}
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public String getNombreCliente() {
			return nombreCliente;
		}
		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}
		public String getNombreMascota() {
			return nombreMascota;
		}
		public void setNombreMascota(String nombreMascota) {
			this.nombreMascota = nombreMascota;
		}
		public int getEdadMascota() {
			return edadMascota;
		}
		public void setEdadMascota(int edadMascota) {
			this.edadMascota = edadMascota;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
	}
	
	protected ArrayList<ObjetoMascota> listaMascota;
	private Scanner Entrada;
	
	//constructor arraylist
	public Mascota() {
		listaMascota = new ArrayList<ObjetoMascota>();
		Entrada = new Scanner (System.in);
	}
	
	//metodo Create
	public void insertarLista(){ 
		
		ObjetoMascota auxiliar = new ObjetoMascota(0, null, null, null, 0, null);
		boolean bandera = false;
		
		//ingreso de datos en objetoMascota
		System.out.println("INGRESE LOS DATOS SOLICITADOS PARA MASCOTA:");
		
		do {
			System.out.print("Código: ");
			auxiliar.setCodigoM(Entrada.nextInt());
			bandera = compararCodigo(auxiliar.getCodigoM());
		}while (bandera);
		
		Entrada.nextLine(); //limpia buffer
		System.out.print("Cedula dueño: ");
		auxiliar.setCedula(Entrada.nextLine());
		System.out.print("Nombre dueño: ");
		auxiliar.setNombreCliente(Entrada.nextLine());
		System.out.print("Nombre mascota: ");
		auxiliar.setNombreMascota(Entrada.nextLine());
		System.out.print("Edad mascota: ");
		auxiliar.setEdadMascota(Entrada.nextInt());
		Entrada.nextLine(); //limpia buffer
		System.out.print("Tipo: ");
		auxiliar.setTipo(Entrada.nextLine());
		
		listaMascota.add(auxiliar);
	}
	
	//metodo Read
	public void mostrarLista() {
		
		ObjetoMascota auxiliar = new ObjetoMascota(0, null, null, null, 0, null);
		int num=0;
		
		System.out.println("==============================================================================================");
		System.out.println("|| Código  |   Cédula 	|  Nombre Dueño  |  Nombre Mascota  | Edad Mascota | Tipo de Mascota |");
		System.out.println("==============================================================================================");
		while(num != listaMascota.size()) {
			auxiliar = listaMascota.get(num);
			System.out.print((num+1)+"\t"+auxiliar.getCodigoM()+"\t"+auxiliar.getCedula()+"\t"+auxiliar.getNombreCliente()+"\t");
			System.out.print(auxiliar.getNombreMascota()+"\t"+auxiliar.getEdadMascota()+"\t"+auxiliar.getTipo()+"\n");
			num++;
		}
		System.out.println("==============================================================================================");
		
	}
	
	//metodo update
	public void modificarNodo() {
		int aux,cod;
		boolean bandera = false;
		ObjetoMascota auxiliar = new ObjetoMascota(0, null, null, null, 0, null);
		
		do {
			System.out.println("Ingrese el codigo de mascota a modificar: ");
			cod = Entrada.nextInt();
			bandera = compararCodigo(cod);
		}while(!bandera);
		aux = obtenerIndice(cod);
		
		System.out.println("INGRESE LOS DATOS SOLICITADOS PARA MASCOTA:");
		do {
			System.out.print("Código: ");
			auxiliar.setCodigoM(Entrada.nextInt());
			bandera = compararCodigo(auxiliar.getCodigoM());
			if(cod == auxiliar.getCodigoM()) {
				bandera = false;
			}
		}while (bandera);
		Entrada.nextLine(); //limpia buffer
		System.out.print("Cedula dueño: ");
		auxiliar.setCedula(Entrada.nextLine());
		System.out.print("Nombre dueño: ");
		auxiliar.setNombreCliente(Entrada.nextLine());
		System.out.print("Nombre mascota: ");
		auxiliar.setNombreMascota(Entrada.nextLine());
		System.out.print("Edad mascota: ");
		auxiliar.setEdadMascota(Entrada.nextInt());
		Entrada.nextLine(); //limpia buffer
		System.out.print("Tipo: ");
		auxiliar.setTipo(Entrada.nextLine());
		
		listaMascota.remove(aux-1);
		listaMascota.add(aux-1,auxiliar);
		System.out.println("NODO ACTUALIZADO");
	}
	
	// metodo borrar
	public void eliminarNodo() {
		int aux;
		int cod;
		boolean bandera;
		//ObjetoMascota auxiliar = new ObjetoMascota(0, null, null, null, 0, null);
		do {
			System.out.println("Ingrese el codigo de mascota a eliminar: ");
			cod = Entrada.nextInt();
			bandera = compararCodigo(cod);
		}while(!bandera);
		
		aux = obtenerIndice(cod);
		listaMascota.remove(aux-1);
		System.out.println("El nodo se ha eliminado con exito!");
	}
	
	// lectura archivo
	public void leerLista() {
		
		listaMascota.clear();
		
		try {
            File archivo = new File("Mascota.txt");
            if (archivo.exists()) {
                FileReader lector = new FileReader(archivo);
				BufferedReader linea = new BufferedReader(lector);
                String aux;
                while ((aux = linea.readLine()) != null) {
                	ObjetoMascota auxiliar = new ObjetoMascota(0, null, null, null, 0, null);
                    String[] cadena = aux.split(" ");
           
                    auxiliar.setCodigoM(Integer.parseInt(cadena[0]));
                    auxiliar.setCedula(cadena[1]);
                    auxiliar.setNombreCliente(cadena[2]);
                    auxiliar.setNombreMascota(cadena[3]);
                    auxiliar.setEdadMascota(Integer.parseInt(cadena[4]));
                    auxiliar.setTipo(cadena[5]);
                    listaMascota.add(auxiliar);
                    
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
		
		ObjetoMascota auxiliar = new ObjetoMascota(0, null, null, null, 0, null);
		
		try {
			File archivo = new File("Mascota.txt");
			FileWriter lector;
			BufferedWriter linea;
			//archivo.delete();
			lector = new FileWriter(archivo);
			linea = new BufferedWriter(lector);
			for(int i = 0; i < listaMascota.size(); i++) {
				auxiliar = listaMascota.get(i);
				if(i==listaMascota.size()-1) {
					linea.write(auxiliar.getCodigoM() + " " + auxiliar.getCedula() + " " + auxiliar.getNombreCliente() + 
							" " + auxiliar.getNombreMascota() + " " + auxiliar.getEdadMascota() + " " + auxiliar.getTipo());
				}else {
					linea.write(auxiliar.getCodigoM() + " " + auxiliar.getCedula() + " " + auxiliar.getNombreCliente() + 
							" " + auxiliar.getNombreMascota() + " " + auxiliar.getEdadMascota() + " " + auxiliar.getTipo()+"\n");
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
		int aux;
		int num=0;
		boolean band=false;
		ObjetoMascota auxiliar = new ObjetoMascota(0, null, null, null, 0, null);
		
		System.out.println("Escoja el codigo de la mascota asignado:");
		aux = Entrada.nextInt();
		
		while(num != listaMascota.size()) {
			auxiliar = listaMascota.get(num);
			if(aux == auxiliar.getCodigoM()) {
				band = true;
				break;
			}
			num++;
		}
		
		if(band == true) {
			System.out.println("==================================================================================");
			System.out.println("|| Cédula 	|  Nombre Mascota  |  Nombre Dueño  | Edad Mascota | Tipo de Mascota |");
			System.out.println("==================================================================================");
			System.out.print(auxiliar.getCodigoM()+"\t"+auxiliar.getCedula()+"\t"+auxiliar.getNombreCliente()+"\t"+auxiliar.getNombreCliente()+"\t");
			System.out.print(auxiliar.getNombreMascota()+"\t"+auxiliar.getEdadMascota()+"\t"+auxiliar.getTipo()+"\n");
		}else {
			System.out.println("La mascota no se encuentra registrada.");
		}
		System.out.println("====================================================================================");
	}
	
	// metodo comparar codigo
	public boolean  compararCodigo(int codigo){
		boolean codigoEncontrado = false;
		try {
            File archivo = new File("Mascota.txt");
            if (archivo.exists()) {
                FileReader lector = new FileReader(archivo);
				BufferedReader linea = new BufferedReader(lector);
                String aux;
                while ((aux = linea.readLine()) != null) {
                	
                    String[] cadena = aux.split(" ");
                    
                    if(codigo == Integer.parseInt(cadena[0])) {
                    	System.out.println("Existe mascota con ese código");
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
	public int obtenerIndice(int cod) {
		int aux=0, num=0;
		while(num != listaMascota.size()){
			if(cod == listaMascota.get(num).getCodigoM()) {
				aux = num+1;
				break;
			}
			num++;
		}
		return aux;
	}
}
