//Antonia Ignacia Cáceres Calderón - 22.050.742-4 - ICCI
//Benjamín Andrés Carrasco Santander - 21.983.969-3 -  ICCI

package primerTaller;

//Acá estan todas las importaciones
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

public class taller1 {

	//Acá se crea el método de sobreescritura para registros
	public static void reescribirTXT1(String txt, String[] lista, int datos) {
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(txt));
				
				for (int i = 0; i < datos; i++) {
					bw.write(lista[i]);
					bw.newLine();
				}
				bw.close();
				
			} catch (IOException e) {
				System.out.println("Error al modificar el texto" + e.getMessage());
			}
			
		}
	//Acá se crea el método de sobreescritura para usuarios
	public static void reescribirTXT2(String txt, String[][] lista, int datos) {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(txt));
			
			for (int i = 0; i < datos; i++) {
				bw.write(lista[i][0] + ";" + lista[i][1]);
				bw.newLine();
			}
			bw.close();
			
		} catch (IOException e) {
			System.out.println("Error al modificar el texto" + e.getMessage());
		}
		
	}
	//Acá se abren ambos archivos
	public static void abrirArchUsuarios() {
    cantidadUsuarios = 0;

    try {
        BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(";");

            usuarios[cantidadUsuarios][0] = partes[0];
            usuarios[cantidadUsuarios][1] = partes[1];

            cantidadUsuarios++;
        }

        br.close();

    } catch (IOException e) {
        System.out.println("Error al leer el archivo " + e.getMessage());
    }
	}
	
    static String[] registros = new String[300];
    static int cantidadRegistros = 0;
    static String[][] usuarios = new String[300][2];
    static int cantidadUsuarios = 0;
    
    
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

        abrirArchUsuarios();

        System.out.println("Usuario: ");
        String ingresoNombre = scanner.nextLine();

        System.out.println("Contraseña: ");
        String ingresoContraseña = scanner.nextLine();

        for (int i = 0; i < cantidadUsuarios; i++) {

            String nombre = usuarios[i][0];
            String contraseña = usuarios[i][1];

            if (nombre.equals(ingresoNombre) && contraseña.equals(ingresoContraseña)) {

                System.out.println("Acceso correcto!");
                System.out.println("Bienvenido " + ingresoNombre + "!");
                System.out.println();

                return i;
            }
        }

        System.out.println("Acceso denegado");
        menuPrincipal(scanner);

        return -1;
    }

    public static void registrarActividad(Scanner scanner) {
    	abrirArchRegistros();
    	String nuevaLinea;

    	System.out.println("Ingresa la nueva actividad (ID;dia/mes/año;cantHoras;Actividad): ");
    	String datos = scanner.nextLine();
    	String[] partes2 = datos.split(";");
    	
    	String ID = partes2[0];
    	String fecha = partes2[1];
    	String horas = partes2[2];
    	String actividad = partes2[3];
    	
    	nuevaLinea = ID + ";" + fecha + ";" + horas + ";" + actividad;
    	registros[cantidadRegistros] = nuevaLinea;
    	cantidadRegistros++;
    	System.out.println("Actividad registrada exitosamente");
    	
    	reescribirTXT1("Registros.txt", registros, cantidadRegistros);
    }

    public static void modificarActividad(Scanner scanner, int indice) {
    	abrirArchRegistros();
    	
		for (int i = 0; i < cantidadRegistros; i++) {
			String[] partes = registros[i].split(";");
			
			if (partes[0].equals(usuarios[indice][0])) { 
				System.out.println((i + 1) + ")" + registros[i]);
            
			}
		}
   
    	System.out.println("¿Cuál actividad deseas modificar?");
    		
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
				modificarActividad(scanner, indice);
				break;
		
			} 	

			registros[actividadModificada] = partes[0] + ";" + fechaa + ";" + nuevasHoras + ";" + nuevaActividad;
			
    		
    	} while (opcionn != 0);
		reescribirTXT1("Registros.txt", registros, cantidadRegistros);
			
    }
    
    public static void eliminarActividad(Scanner scanner) {
    	abrirArchRegistros();
    	System.out.println("¿Qué actividad deseas eliminar?");
    	
    	for (int i = 0; i < cantidadRegistros; i++) {
            System.out.println((i + 1) + ")" + registros[i]);
        }
    	
    	int actividadEliminada = Integer.parseInt(scanner.nextLine()) -1;
    	
    	for (int i = actividadEliminada; i < cantidadRegistros; i++) {
    		registros[i] = registros[i + 1];
    	}
    	
    	registros[cantidadRegistros - 1] = null;
    	cantidadRegistros--;
    	reescribirTXT1("Registros.txt", registros, cantidadRegistros);
    	System.out.println("Actividad eliminada con éxito");
    	System.out.println();
    	
    	
    }
    
    public static void cambiarContraseña(Scanner scanner, int indice) {

        abrirArchUsuarios();

        System.out.println("Ingrese contraseña anterior:");
        String anteriorContra = scanner.nextLine();

        if (usuarios[indice][1].equals(anteriorContra)) {

            System.out.println("Ingrese nueva contraseña:");
            String nuevaContra = scanner.nextLine();

            usuarios[indice][1] = nuevaContra;

            System.out.println("Contraseña cambiada con éxito");
            System.out.println();
            
            reescribirTXT2("Usuarios.txt", usuarios, cantidadUsuarios);

        } else {

            System.out.println("Contraseña incorrecta");
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
        			modificarActividad(scanner, indice);
        			break;
        			
        		case 3:
        			eliminarActividad(scanner);
        			break;
        			
        		case 4:
        			cambiarContraseña(scanner, indice);
        			break;
        			
        		case 5:
        			System.out.println("Saliendo...");
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
    abrirArchUsuarios();

    for (int u = 0; u < cantidadUsuarios; u++) {

        String usuario = usuarios[u][0];

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

        if (cantidadActividades > 0) {
            System.out.println(usuario + " -> " + actividades[pos] + " -> con " + horasTotales[pos] + " horas registradas");
        }
    }
}

    public static void usuarioMasProcastinacion() {

        abrirArchUsuarios();

        String usuarioMax = "";
        int maxHoras = 0;

        for (int u = 0; u < cantidadUsuarios; u++) {

            String usuario = usuarios[u][0];
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
                	}
                    break;
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













