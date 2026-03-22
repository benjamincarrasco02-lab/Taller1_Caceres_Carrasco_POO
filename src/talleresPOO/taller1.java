//Antonia Ignacia Cáceres Calderón - 22.050.742-4 - ICCI
//Benjamín Andrés Carrasco Santander - 21.983.969-3 -  ICCI
package talleresPOO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class taller1 {

	//Función para leer el txt de usuarios y sus contraseñas
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
    
    public static void menuUsuarios(Scanner scanner) {
    	
    	 ArrayList<String[]> listaID = abrirArchUsuarios();
    	
    	String[] partes2 = listaID.get(0);
        String listaNombres = partes2[0];
        String listaContraseñas = partes2[1];
        
        System.out.println(listaNombres);
        System.out.println(listaContraseñas);
        
        if ((op) == 1) {
        	System.out.println("Usuario: ");
            String ingresoNombre = String.valueOf(scanner.nextLine());
            
            while ((!listaID.contains(ingresoNombre))) {
                System.out.println("Usuario no existente. Vuelva a intentar");
                ingresoNombre = String.valueOf(scanner.nextLine());
                }
            
            System.out.println("Contraseña: ");
            String ingresoContraseña = String.valueOf(scanner.nextLine());
            
     
            
            
            }
    	
    	
    	
    }
    
    public static void menuAnalisis(Scanner scanner){
        int op;
        do {
            System.out.println("Bienvenido al menu de analisis! \nQue deseas realizar?");
            System.out.println("1) Actividad más realizada");
            System.out.println("2) Actividad más realizada por cada usuario");
            System.out.println("3) Usuario con mayor procastinacion");
            System.out.println("4) Ver todas las actividades");
            System.out.println("5) Salir");

            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Actividad más realizada");
                    break;
                case 2:
                    System.out.println("Actividad más realizada por cada usuario");
                    break;
                case 3:
                    System.out.println("Usuario con mayor procastinacion");
                    break;
                case 4:
                    System.out.println("Ver todas las actividades");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (op != 5);
    }
    
    public static void menuPrincipal(Scanner scanner) {
        int op;
        do {
        	System.out.println("¡Bienvenido!\nPorfavor escoja una opción:\n1) Menu de Usuarios\n2) Menu de Analisis\n3) Salir");
            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    menuUsuarios(scanner);
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

        } while (op != 3);
    }

    public static void main(String[] args) {
        
        //Acá empieza el inicio de los menús

        Scanner scanner = new Scanner(System.in);
        
       //Acá abrimos el menú principal
        menuPrincipal(scanner);
        
        
        
        
        
             
            
        scanner.close();
    }

        } 













