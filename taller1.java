//Antonia Ignacia Cáceres Calderón - 22.050.742-4 - ICCI
//Benjamín  Andrés Carrasco Santander - 21.983.969-3 -  ICCI
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class taller1 {


    public static void abrirArchUsuarios() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"));
            String linea = br.readLine();
            
            while ((linea) != null) {
                String partes[] = linea.split(";");
                String ID = partes[0];
                String contraseña = partes[1];
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
    }

    public static void main(String[] args) {

        // Acá empezamos por abrir el archivo de usuarios

        abrirArchUsuarios();
        
        //Acá empieza el inicio de los menús

        System.out.println("¡Bienvenido!\nPorfavor escoja una opción:\n1) Menu de Usuarios\n2) Menu de Analisis\n3) Salir");
        Scanner scanner = new Scanner(System.in);
        
        int op = Integer.valueOf(scanner.nextLine());

        do {
            System.out.println("Opción inválida. Inténtelo de nuevo");
            op = Integer.valueOf(scanner.nextLine());
        } while (op != 1 && op != 2 && op != 3);

        scanner.close();
    }
}
