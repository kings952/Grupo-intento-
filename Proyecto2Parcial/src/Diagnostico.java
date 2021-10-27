import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Diagnostico {
	
	//subclase objeto mascota
	private class ObjetoDiagnostico{
		private int codigoM;
		private String codigoV;
		private float peso;
		private float presion;
		private float temperatura;
		private String diagnostico;
		
		//constructor
		public ObjetoDiagnostico(int codigoM, String codigoV, float peso, float presion, float temperatura,
				String diagnostico) {
			this.codigoM = codigoM;
			this.codigoV = codigoV;
			this.peso = peso;
			this.presion = presion;
			this.temperatura = temperatura;
			this.diagnostico = diagnostico;
		}

		public int getCodigoM() {
			return codigoM;
		}

		public void setCodigoM(int codigoM) {
			this.codigoM = codigoM;
		}

		public String getCodigoV() {
			return codigoV;
		}

		public void setCodigoV(String codigoV) {
			this.codigoV = codigoV;
		}

		public float getPeso() {
			return peso;
		}

		public void setPeso(float peso) {
			this.peso = peso;
		}

		public float getPresion() {
			return presion;
		}

		public void setPresion(float presion) {
			this.presion = presion;
		}

		public float getTemperatura() {
			return temperatura;
		}

		public void setTemperatura(float temperatura) {
			this.temperatura = temperatura;
		}

		public String getDiagnostico() {
			return diagnostico;
		}

		public void setDiagnostico(String diagnostico) {
			this.diagnostico = diagnostico;
		}
	}
	
	private ArrayList<ObjetoDiagnostico> listaDiagnostico;
	private Scanner Entrada;
	
	//constructor arraylist
	public Diagnostico() {
		listaDiagnostico = new ArrayList<ObjetoDiagnostico>();
		Entrada = new Scanner (System.in);
	}
	
	//metodo Create
	public void insertarLista(Mascota lista1, Veterinario lista2){ 
		
		ObjetoDiagnostico auxiliar = new ObjetoDiagnostico(0, null, 0, 0, 0, null);
		boolean bandera = false;
		
		//ingreso de datos en ObjetoDiagnostico
		System.out.println("INGRESE LOS DATOS SOLICITADOS PARA DIAGNOSTICO:");
		
		do {
			lista1.mostrarLista();
			System.out.print("\nCódigo: ");
			auxiliar.setCodigoM(Entrada.nextInt());
			bandera = lista1.compararCodigo(auxiliar.getCodigoM());
			if(!bandera) {
				System.out.println("Error: el codigo debe existir en Registro de Mascotas ");
				Principal.limpiarConsola(50);
			}
		}while (!bandera);
		
		Entrada.nextLine(); //limpia buffer
		
		do {
			lista2.mostrarLista();
			System.out.print("Cedula Veterinario: ");
			auxiliar.setCodigoV(Entrada.nextLine());
			bandera = lista2.compararCodigo(auxiliar.getCodigoV());
			if(!bandera) {
				System.out.println("Error: la cedula debe existir en Registro de Veterinario ");
				Principal.limpiarConsola(50);
			}
		}while (!bandera);
		
		System.out.print("Peso: ");
		auxiliar.setPeso(Entrada.nextFloat());
		System.out.print("Presion: ");
		auxiliar.setPresion(Entrada.nextFloat());
		System.out.print("Temperatura: ");
		auxiliar.setTemperatura(Entrada.nextFloat());
		Entrada.nextLine(); //limpia buffer
		System.out.print("Diagnostico: ");
		auxiliar.setDiagnostico(Entrada.nextLine());
		
		listaDiagnostico.add(auxiliar);
	}
	
	//metodo Read
	public void mostrarLista(Mascota lista1, Veterinario lista2) {
		
		ObjetoDiagnostico auxiliar = new ObjetoDiagnostico(0, null, 0, 0, 0, null);
		int num=0;
		
		System.out.println("==========================================================================================================================================");
		System.out.println("|| Código Mascota |   Cédula veterinario | Nombre Veterinario |   Nombre Mascota |  Peso  |  Presion  | Temperatura | Diagnostico |");
		System.out.println("==========================================================================================================================================");
		while(num != listaDiagnostico.size()) {
			auxiliar = listaDiagnostico.get(num);
			System.out.print((num+1)+"\t"+auxiliar.getCodigoM()+"\t\t"+auxiliar.getCodigoV()+"\t\t");
			System.out.print(lista2.listaVeterinario.get(lista2.obtenerIndice(auxiliar.getCodigoV())-1).getNombre()+"\t\t\t");
			System.out.print(lista1.listaMascota.get(lista1.obtenerIndice(auxiliar.getCodigoM())-1).getNombreMascota()+"\t\t");
			System.out.print(auxiliar.getPeso()+"\t"+auxiliar.getPresion()+"\t"+auxiliar.getTemperatura()+"\t\t"+auxiliar.getDiagnostico()+"\n");
			num++;
		}
		System.out.println("==========================================================================================================================================");
		
	}
	
	//metodo update
	public void modificarNodo(Mascota lista1, Veterinario lista2) {
		int cod=0;
		boolean bandera = false;
		String ced= null;
		
		ArrayList<Integer> aux = new ArrayList<Integer>();
		ObjetoDiagnostico auxiliar = new ObjetoDiagnostico(0, null, 0, 0, 0, null);
		
		//ingresa codigo y cedula del nodo a modificar
		do {
			mostrarLista(lista1,lista2);
			System.out.print("\nCódigo: ");
			cod=Entrada.nextInt();
			bandera = lista1.compararCodigo(cod);
			if(!bandera) {
				System.out.println("Error: el codigo debe existir en Registro de Mascotas ");
				Principal.limpiarConsola(50);
			}
		}while (!bandera);
		
		Entrada.nextLine(); //limpia buffer
		
		do {
			mostrarLista(lista1,lista2);
			System.out.print("Cedula Veterinario: ");
			ced=Entrada.nextLine();
			bandera = lista2.compararCodigo(ced);
			if(!bandera) {
				System.out.println("Error: la cedula debe existir en Registro de Veterinario ");
				Principal.limpiarConsola(50);
			}
		}while (!bandera);
		
		aux = obtenerIndice( cod, ced);
		
		//modificacion de los nodos que cumplen el criterio
		if(aux.isEmpty()) {
			System.out.println("No existe el registro ingresado");
		}else {
			for (int i=0; i<aux.size();i++) {
				System.out.println("INGRESE LOS DATOS SOLICITADOS PARA DIAGNOSTICO DE LA POSICIÓN" + aux.get(i));
				do {
					lista1.mostrarLista();
					System.out.print("\nCódigo: ");
					auxiliar.setCodigoM(Entrada.nextInt());
					bandera = lista1.compararCodigo(auxiliar.getCodigoM());
					if(!bandera) {
						System.out.println("Error: el codigo debe existir en Registro de Mascotas ");
						Principal.limpiarConsola(50);
					}
				}while (!bandera);
				
				Entrada.nextLine(); //limpia buffer
				
				do {
					lista2.mostrarLista();
					System.out.print("Cedula Veterinario: ");
					auxiliar.setCodigoV(Entrada.nextLine());
					bandera = lista2.compararCodigo(auxiliar.getCodigoV());
					if(!bandera) {
						System.out.println("Error: la cedula debe existir en Registro de Veterinario ");
						Principal.limpiarConsola(50);
					}
				}while (!bandera);
				
				System.out.print("Peso: ");
				auxiliar.setPeso(Entrada.nextFloat());
				System.out.print("Presion: ");
				auxiliar.setPresion(Entrada.nextFloat());
				System.out.print("Temperatura: ");
				auxiliar.setTemperatura(Entrada.nextFloat());
				Entrada.nextLine(); //limpia buffer
				System.out.print("Diagnostico: ");
				auxiliar.setDiagnostico(Entrada.nextLine());
				
				listaDiagnostico.remove(aux.get(i)-1);
				listaDiagnostico.add(aux.get(i)-1,auxiliar);
				System.out.println("NODO"+ aux.get(i)+ "ACTUALIZADO");
			}
		}
	}
	
	// metodo borrar
	public void eliminarNodo(Mascota lista1, Veterinario lista2) {
		int cod=0;
		String ced= null;
		boolean bandera = false;
		
		ArrayList<Integer> aux = new ArrayList<Integer>();
		ObjetoDiagnostico auxiliar = new ObjetoDiagnostico(0, null, 0, 0, 0, null);
		
		do {
			mostrarLista(lista1,lista2);
			System.out.print("\nCódigo: ");
			cod=Entrada.nextInt();
			bandera = lista1.compararCodigo(cod);
			if(!bandera) {
				System.out.println("Error: el codigo debe existir en Registro de Mascotas ");
				Principal.limpiarConsola(50);
			}
		}while (!bandera);
		
		Entrada.nextLine(); //limpia buffer
		
		do {
			mostrarLista(lista1,lista2);
			System.out.print("Cedula Veterinario: ");
			ced=Entrada.nextLine();
			bandera = lista2.compararCodigo(ced);
			if(!bandera) {
				System.out.println("Error: la cedula debe existir en Registro de Veterinario ");
				Principal.limpiarConsola(50);
			}
		}while (!bandera);
		
		aux = obtenerIndice( cod, ced);
		
		if(aux.isEmpty()) {
			System.out.println("No existe registro a borrar ");
		}else {
			for(int j=0; j <aux.size(); j++) {
				listaDiagnostico.remove(aux.get(j)-1);
				System.out.println("El nodo "+aux.get(j)+"se ha eliminado con exito!");
			}
		}
		
	}
	
	// lectura archivo
	public void leerLista() {
		
		listaDiagnostico.clear();
		
		try {
            File archivo = new File("Diagnosticos.txt");
            if (archivo.exists()) {
                FileReader lector = new FileReader(archivo);
				BufferedReader linea = new BufferedReader(lector);
                String aux;
                while ((aux = linea.readLine()) != null) {
                	ObjetoDiagnostico auxiliar = new ObjetoDiagnostico(0, null, 0, 0, 0, null);
                    String[] cadena = aux.split(" ");
           
                    auxiliar.setCodigoM(Integer.parseInt(cadena[0]));
                    auxiliar.setCodigoV(cadena[1]);
                    auxiliar.setPeso(Float.parseFloat(cadena[2]));
                    auxiliar.setPresion(Float.parseFloat(cadena[3]));
                    auxiliar.setTemperatura(Float.parseFloat(cadena[4]));
                    auxiliar.setDiagnostico(cadena[5]);
                    listaDiagnostico.add(auxiliar);
                    
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
		
		ObjetoDiagnostico auxiliar = new ObjetoDiagnostico(0, null, 0, 0, 0, null);
		
		try {
			File archivo = new File("Diagnosticos.txt");
			FileWriter lector;
			BufferedWriter linea;
			//archivo.delete();
			lector = new FileWriter(archivo);
			linea = new BufferedWriter(lector);
			for(int i = 0; i < listaDiagnostico.size(); i++) {
				auxiliar = listaDiagnostico.get(i);
				if(i==listaDiagnostico.size()-1) {
					linea.write(auxiliar.getCodigoM() + " " + auxiliar.getCodigoV() + " " + auxiliar.getPeso() + 
							" " + auxiliar.getPresion() + " " + auxiliar.getTemperatura() + " " + auxiliar.getDiagnostico());
				}else {
					linea.write(auxiliar.getCodigoM() + " " + auxiliar.getCodigoV() + " " + auxiliar.getPeso() + 
							" " + auxiliar.getPresion() + " " + auxiliar.getTemperatura() + " " + auxiliar.getDiagnostico()+"\n");
				}
			}
			linea.close();
			lector.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	// metodo buscar registro
	public void buscarRegistro(Mascota lista1, Veterinario lista2) {
		
		int cod=0;
		String ced= null;
		boolean bandera = false;
		
		ArrayList<Integer> aux = new ArrayList<Integer>();
		ObjetoDiagnostico auxiliar = new ObjetoDiagnostico(0, null, 0, 0, 0, null);
		
		//ingresa codigo y cedula del nodo a buscar

		
		//ingreso de datos en ObjetoDiagnostico
		System.out.println("INGRESE LOS DATOS A BUSCAR:");
		
		do {
			lista1.mostrarLista();
			System.out.print("\nCódigo: ");
			cod=Entrada.nextInt();
			bandera = lista1.compararCodigo(cod);
			if(!bandera) {
				System.out.println("Error: el codigo debe existir en Registro de Mascotas ");
				Principal.limpiarConsola(50);
			}
		}while (!bandera);
		
		Entrada.nextLine(); //limpia buffer
		
		do {
			lista2.mostrarLista();
			System.out.print("Cedula Veterinario: ");
			ced=Entrada.nextLine();
			bandera = lista2.compararCodigo(ced);
			if(!bandera) {
				System.out.println("Error: la cedula debe existir en Registro de Veterinario ");
				Principal.limpiarConsola(50);
			}
		}while (!bandera);
		
		aux = obtenerIndice( cod, ced);
		
		if(!aux.isEmpty()) {
			System.out.println("==========================================================================================================================================");
			System.out.println("|| Código Mascota |   Cédula veterinario | Nombre Veterinario |   Nombre Mascota |  Peso  |  Presion  | Temperatura | Diagnostico |");
			System.out.println("==========================================================================================================================================");
			for(int k=0; k<aux.size();k++) {
				auxiliar = listaDiagnostico.get(aux.get(k)-1);
				System.out.print((aux.get(k))+"\t"+auxiliar.getCodigoM()+"\t\t"+auxiliar.getCodigoV()+"\t\t");
				System.out.print(lista2.listaVeterinario.get(lista2.obtenerIndice(auxiliar.getCodigoV())-1).getNombre()+"\t\t\t");
				System.out.print(lista1.listaMascota.get(lista1.obtenerIndice(auxiliar.getCodigoM())-1).getNombreMascota()+"\t\t");
				System.out.print(auxiliar.getPeso()+"\t"+auxiliar.getPresion()+"\t"+auxiliar.getTemperatura()+"\t\t"+auxiliar.getDiagnostico()+"\n");
			}
			
		}else {
			System.out.println("El diagnostico no se encuentra registrada.");
		}
		System.out.println("====================================================================================");
	}
	/*
	// metodo comparar codigo
	public int  compararCodigo(int codigo, String cedula){
		int codigoEncontrado = 0;
		try {
            File archivo = new File("Diagnosticos.txt");
            if (archivo.exists()) {
                FileReader lector = new FileReader(archivo);
				BufferedReader linea = new BufferedReader(lector);
                String aux;
                while ((aux = linea.readLine()) != null) {
                	
                    String[] cadena = aux.split(" ");
                    
                    if(codigo == Integer.parseInt(cadena[0]) && cedula == cadena[1]) {
                    	System.out.println("Existe diagnostico con esos atributos");
                    	codigoEncontrado = 3;
                    	break;
                    } else if(codigo == Integer.parseInt(cadena[0])) {
                    	System.out.println("Ingrese de nuevo cedula\n");
                    	codigoEncontrado = 2;
                    	break;
                    } else if(cedula == cadena[1]) {
                    	System.out.println("Ingrese de nuevo codigo\n");
                    	codigoEncontrado = 1;
                    	break;
                    } else {
                    	System.out.println("Ingrese de nuevo codigo y cedula\n");
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
	*/
	
	//metodo obtener indice
	public ArrayList<Integer> obtenerIndice(int cod, String ced) {
		int  num=0, int1=0;
		String cad1 = null;
		ArrayList<Integer> aux = new ArrayList<Integer>();
		
		
		while(num < listaDiagnostico.size()){
			
			int1=listaDiagnostico.get(num).getCodigoM();
			cad1 = listaDiagnostico.get(num).getCodigoV();
			
			//&& (ced == cad1
			if((cod == int1) && (ced.equals(cad1))) {
				aux.add(num+1);
			}
			
			num++;
			
		}
		
		return aux;
	}
}
