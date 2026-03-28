//Antonia Ignacia Cáceres Calderón - 22.050.742-4 - ICCI
//Benjamín Andrés Carrasco Santander - 21.983.969-3 -  ICCI
package primerTaller;
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
  	ArrayList<String[]> listaUsuarios = abrirArchUsuarios();
  	
  	System.out.println("Usuario: ");
      String ingresoNombre = String.valueOf(scanner.nextLine());
  	
      System.out.println("Contraseña: ");
      String ingresoContraseña = String.valueOf(scanner.nextLine());

  	for (int i = 0; i < listaUsuarios.size(); i++) {

  		if (listaUsuarios.get(i)[0].equals(ingresoNombre) && listaUsuarios.get(i)[1].equals(ingresoContraseña)) {
  			System.out.println("Acceso correcto!");
  			break;
  		} else {
  			System.out.println("Acceso denegado");
  		}	
  	}       
  }

  static String[] registros = new String[300];
  static int cantidadRegistros = 0;

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
  
  public static int menuPrincipal(Scanner scanner) {
      int op;
      do {
      	System.out.println("¡Bienvenido!\nPorfavor escoja una opción:\n1) Menu de Usuarios\n2) Menu de Analisis\n3) Salir");
          try {
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
      } catch (Exception e) {
          System.out.println("Opción inválida, Ingresa el numero de la opcion");
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













