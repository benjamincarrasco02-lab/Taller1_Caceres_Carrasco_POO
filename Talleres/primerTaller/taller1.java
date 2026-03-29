//Antonia Ignacia Cáceres Calderón - 22.050.742-4 - ICCI
//Benjamín Andrés Carrasco Santander - 21.983.969-3 -  ICCI

package primerTaller;

//Acá estan todas las importaciones
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class taller1 {

	//Acá se abren ambos archivos
	
    public static ArrayList<String[]> abrirArchUsuarios() {
    	
    	ArrayList<String[]> listaPartes = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"));
            String linea = br.readLine();
           
            while ((linea) != null) {
                String[] partes = linea.split(";");
                listaPartes.add(partes);
                
                linea = br.readLine();
            }
            br.close(); 
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
        return listaPartes;
    }  

    static String[] registros = new String[300];
    static int cantidadRegistros = 0;
    
    public static void abrirArchRegistros() {
        cantidadRegistros = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Registros.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                registros[cantidadRegistros] = linea;
                cantidadRegistros++;
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    //Desde acá se empeiza a trabajar el menú de usuarios
    
   
    public static int verificarUsuarios(Scanner scanner) {
    	
	ArrayList<String[]> listaUsuarios = abrirArchUsuarios();
	    	
	    	System.out.println("Usuario: ");
	        String ingresoNombre = scanner.nextLine();	    	
	        System.out.println("Contraseña: ");
	        String ingresoContraseña = scanner.nextLine();
	        
	        int i;
	    	for (i = 0; i < listaUsuarios.size(); i++) {
	    		String[] usuario = listaUsuarios.get(i);
	    		
	    		String nombre = usuario[0];
	    		String contraseña = usuario[1];
	    		
	    		if (nombre.equals(ingresoNombre) && contraseña.equals(ingresoContraseña)) {
	    			System.out.println("Acceso correcto!");
	        		System.out.printf("Bienvenido " + ingresoNombre + "!");
	        		System.out.println();
	        		return i;
	        		
	    	}
		
	    }
	    	System.out.println("Acceso denegado");
			menuPrincipal(scanner);
			return -1;
    }
    //REVISAR****
    public static void registrarActividad(Scanner scanner) {
    	abrirArchRegistros();
    	String[] partes = registros[0].split(";");
    	String ID = partes[0];
    	String fecha = partes[1];
    	String horas = partes[2];
    	String actividad = partes[3];
    	
    	String nuevaLinea = ID + ";" + fecha + ";" + horas + ";" + actividad;
    	
    	do {
        	System.out.println("Ingresa la nueva actividad (ID;dia/mes/año;cantHoras;Actividad): ");
        	String datos = scanner.nextLine();
        	String[] partes2 = datos.split(";");
        	
        	ID = partes2[0];
        	fecha = partes2[1];
        	horas = partes2[2];
        	actividad = partes2[3];
        	
        	nuevaLinea = ID + ";" + fecha + ";" + horas + ";" + actividad;
        	int tamaño = registros.length;
        	int nuevoTamaño = tamaño + 1;
        	//Revisar*******
        	registros[nuevoTamaño] = nuevaLinea;
        	System.out.println(nuevaLinea);
        	
    	} while (nuevaLinea.length() != 4);
    	
    	
    }
    
    public static void modificarActividad(Scanner scanner) {
    	abrirArchRegistros();
    	System.out.println("¿Cuál actividad deseas modificar?");
    	
    	
    	for (int i = 0; i < cantidadRegistros; i++) {
            System.out.println((i + 1) + ")" + registros[i]);
        }	
    		
    	int actividadModificada = Integer.parseInt(scanner.nextLine()) -1;
    	
    	String[] partes = registros[actividadModificada].split(";");
    	String fechaa = partes[1];
    	String nuevasHoras = partes[2];
    	String nuevaActividad = partes[3];
    	
    	int opcionn;
    	
		do {
			System.out.println("¿Qué deseas modificar?\n0) Regresar\n1) Fecha\n2) Duracion\n3) Tipo de actividad");
		
			opcionn = Integer.parseInt(scanner.nextLine());
			
			switch (opcionn) {
			
			case 0:
				System.out.println("Regresando...");
				break;
			
			case 1:
				System.out.println("Ingrese nueva fecha: ");
				fechaa = scanner.nextLine();
				System.out.println("Fecha modificada con éxito!");
				System.out.println();
				break;
				
			case 2:
				System.out.println("Ingrese nueva duración: ");
				nuevasHoras = scanner.nextLine();
				System.out.println("Horas modificadas con éxito!");
				System.out.println();
				break;
				
			case 3:
				System.out.println("Ingrese el tipo de actividad: ");
				nuevaActividad = scanner.nextLine();
				System.out.println("Actividad modificada con éxito!");
				System.out.println();
				break;
				
			default:
				System.out.println("Opción inválida");
				System.out.println();
				modificarActividad(scanner);
				break;
		
			} 

			registros[actividadModificada] = partes[0] + ";" + fechaa + ";" + nuevasHoras + ";" + nuevaActividad;
			
    		
    	} while (opcionn != 0);
			
    }
    
    public static void eliminarActividad(Scanner scanner) {
    	
    	System.out.println("¿Qué actividad deseas eliminar?");
    	
    	for (int i = 0; i < cantidadRegistros; i++) {
            System.out.println((i + 1) + ")" + registros[i]);
        }
    	
    	int actividadEliminada = Integer.parseInt(scanner.nextLine()) -1;
    	
    	registros[actividadEliminada] = null;
    	System.out.println("Actividad eliminada con éxito");
    	System.out.println();
    }
    
    public static void cambiarContraseña(Scanner scanner, int indice) {
    	
    	ArrayList<String[]> listaUsuarios = abrirArchUsuarios();
    	

    	System.out.println("Ingrese contraseña anterior: ");
    	String anteriorContra = scanner.nextLine();
    	
    	String[] datoss = listaUsuarios.get(indice);

		if (datoss[1].equals(anteriorContra)) {

			System.out.println("Ingrese nueva contraseña: ");
	    	String nuevaContra = scanner.nextLine();
			
	    	datoss[1] = nuevaContra;
	    	
	    	System.out.println("Contraseña cambiada con éxito");
	    	System.out.println();
	    	

		} else {
	
			System.out.println("Contraseña incorrecta\nPor seguridad, verifica nuevamente tu identidad porfavor");
            menuUsuarios(scanner, indice);
            
    	}

    	
    }
       
    public static void menuUsuarios(Scanner scanner, int indice) {

    	System.out.println("\n¿Qué deseas realizar?");
    	System.out.println();
    	
    	int ingresoOpcion;
    	
    	do {
    		System.out.println("1) Registrar actividad.\n2) Modificar actividad.\n3) Eliminar actividad.\n4) Cambiar contraseña.\n5) Salir.");
    		ingresoOpcion = Integer.valueOf(scanner.nextLine());
        	
        	switch(ingresoOpcion) {
        	 
        		case 1:
        			registrarActividad(scanner);
        			break;
        			
        		case 2:
        			modificarActividad(scanner);
        			break;
        			
        		case 3:
        			eliminarActividad(scanner);
        			break;
        			
        		case 4:
        			cambiarContraseña(scanner, indice);
        			break;
        			
        		case 5:
        			System.out.println("Saliendo...");
        			menuPrincipal(scanner);
        			break;
        			
        		default:
        			System.out.println("Opción inválida");
        	
        	} 
        		
        	
        	
    	} while (ingresoOpcion != 5);
  	
            
    }

    //Desde acá se empieza a trabajar el menú de Análisis
   

    public static void verTodas(){
        for (int i = 0; i < cantidadRegistros; i++) {
            System.out.println(registros[i]);
        }
    }

    public static void actividadMasRealizada(){
        String actividadMasRealizada = "";
        int cantidadActividadMasRealizada = 0;

        for (int i = 0; i < cantidadRegistros; i++) {
            String[] partes = registros[i].split(";");
            String actividad = partes[3];

            int contadorActividad = 0;
            for (int j = 0; j < cantidadRegistros; j++) {
                String[] partesComparacion = registros[j].split(";");
                String actividadComparacion = partesComparacion[3];

                if (actividad.equals(actividadComparacion)) {
                    contadorActividad++;
                }
            }

            if (contadorActividad > cantidadActividadMasRealizada) {
                cantidadActividadMasRealizada = contadorActividad;
                actividadMasRealizada = actividad;
            }
        }

        System.out.println("La actividad más realizada es: " + actividadMasRealizada);
    }

    public static void actividadMasRealizadaPorCadaUsuario() {
    ArrayList<String[]> listaUsuarios = abrirArchUsuarios();

    for (int u = 0; u < listaUsuarios.size(); u++) {

        String usuario = listaUsuarios.get(u)[0];

        String[] actividades = new String[300];
        int[] contador = new int[300];
        int[] horasTotales = new int[300];

        int cantidadActividades = 0;

        for (int i = 0; i < cantidadRegistros; i++) {

            String[] partes = registros[i].split(";");
            String user = partes[0];
            String actividad = partes[3];
            int horas = Integer.parseInt(partes[2]);

            if (user.equals(usuario)) {

                boolean encontrada = false;

                for (int j = 0; j < cantidadActividades; j++) {

                    if (actividades[j].equals(actividad)) {
                        contador[j]++;
                        horasTotales[j] += horas;
                        encontrada = true;
                        break;
                    }
                }

                if (!encontrada) {
                    actividades[cantidadActividades] = actividad;
                    contador[cantidadActividades] = 1;
                    horasTotales[cantidadActividades] = horas;
                    cantidadActividades++;
                }
            }
        }

        int max = 0;
        int pos = 0;

        for (int i = 0; i < cantidadActividades; i++) {
            if (contador[i] > max) {
                max = contador[i];
                pos = i;
            }
        }

        System.out.println(usuario + " -> " + actividades[pos] + " -> con " + horasTotales[pos] + " horas registradas");
    }
}

    public static void usuarioMasProcastinacion() {
    ArrayList<String[]> listaUsuarios = abrirArchUsuarios();

    String usuarioMax = "";
    int maxHoras = 0;

    for (int u = 0; u < listaUsuarios.size(); u++) {

        String usuario = listaUsuarios.get(u)[0];
        int suma = 0;

        for (int i = 0; i < cantidadRegistros; i++) {

            String[] partes = registros[i].split(";");

            if (partes[0].equals(usuario)) {
                suma += Integer.parseInt(partes[2]);
            }
        }

        if (suma > maxHoras) {
            maxHoras = suma;
            usuarioMax = usuario;
        }
    }

    System.out.println("Usuario con mayor procrastinación: " + usuarioMax + " (" + maxHoras + " horas)");
}
   
    public static void menuAnalisis(Scanner scanner){
        int op;
        do {
            System.out.println("Bienvenido al menu de análisis! \n¿Qué deseas realizar?");
            System.out.println("1) Actividad más realizada");
            System.out.println("2) Actividad más realizada por cada usuario");
            System.out.println("3) Usuario con mayor procastinacion");
            System.out.println("4) Ver todas las actividades");
            System.out.println("5) Salir");

            op = Integer.parseInt(scanner.nextLine());
            abrirArchRegistros();
            switch (op) {
                case 1:
                    actividadMasRealizada();
                    break;
                case 2:
                    actividadMasRealizadaPorCadaUsuario();
                    break;
                case 3:
                    usuarioMasProcastinacion();
                    break;
                case 4:
                    verTodas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (op != 5);
    }
    
    //Acá tenemos el menú principál (el de las opciones) y el main
    
    public static int menuPrincipal(Scanner scanner) {
    	
        int op;
        do {
        	System.out.println("¡Bienvenido!\nPorfavor escoja una opción:\n1) Menu de Usuarios\n2) Menu de Análisis\n3) Salir");
        	
            try {
            op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1:
                	int indice = verificarUsuarios(scanner);
                	if (indice != -1) {
                		menuUsuarios(scanner, indice);
                        break;
                	}
                    
                case 2:
                    menuAnalisis(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } catch (Exception e) {
            System.out.println("Opción inválida, Ingresa el número de la opcion");
            op = 0;
        }
    } while (op != 3);
    
        return op;
    
    } 

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        //Acá abrimos el menú principal
        menuPrincipal(scanner);
        
        
    }

        } 














