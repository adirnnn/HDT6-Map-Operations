package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Aquí se solicita al usuario que elija la implementación del MAP
        System.out.println("Elige la implementación del MAP que quieras: (1) HashMap, (2) TreeMap, (3) LinkedHashMap");
        int eleccion = scanner.nextInt();

        CardCollection coleccionCartas;
        switch (eleccion) {
            case 1:
                coleccionCartas = new HashMapCardCollection(); // Crea la colección usando HashMap
                break;
            case 2:
                coleccionCartas = new TreeMapCardCollection(); // Crea la colección usando TreeMap
                break;
            case 3:
                coleccionCartas = new LinkedHashMapCardCollection(); // Crea la colección usando LinkedHashMap
                break;
            default:
                System.out.println("Opción inválida. Se usará la implementación predeterminada de HashMap.");
                coleccionCartas = new HashMapCardCollection(); // Usa HashMap como predeterminado solo por defensive programming
        }

        try {
            // Para leer el archivo de las cartas
            BufferedReader lector = new BufferedReader(new FileReader("src/main/java/uvg/edu/gt/resources/cards_desc.txt"));
            String linea;
            while ((linea = lector.readLine()) != null) {
                // Para dividir la línea en partes separadas por "|" por a estructura del txt file
                String[] partes = linea.split("\\|");
                String nombreCarta = partes[0].trim(); // Obtiene el nombre de la carta
                String tipoCarta = partes[1].trim(); // Obtiene el tipo de la carta
                // Para agregar la carta a la colección
                coleccionCartas.agregarCarta(nombreCarta, tipoCarta);
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage()); // Manejar errores de lectura de archivo solo por defensive programming
        }

        int opcion;
        // Ciclo para mostrar el menú y procesar las opciones del usuario
        do {
            // Menú de opciones
            System.out.println("\nElige una opción:");
            System.out.println("1. Agregar una carta a la colección");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta en la colección");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta en la colección, ordenada por tipo");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas, ordenadas por tipo");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre de la carta a agregar:");
                    scanner.nextLine();
                    String nombreCartaAgregar = scanner.nextLine();
                    coleccionCartas.agregarCarta(nombreCartaAgregar, "");
                    System.out.println("Carta agregada a la colección.");
                    break;
                case 2:
                    System.out.println("Ingresa el nombre de la carta para obtener su tipo:");
                    scanner.nextLine();
                    String nombreCartaObtenerTipo = scanner.nextLine();
                    String tipoCarta = coleccionCartas.obtenerTipoCarta(nombreCartaObtenerTipo);
                    if (tipoCarta != null) {
                        System.out.println("El tipo de carta '" + nombreCartaObtenerTipo + "' es: " + tipoCarta);
                    } else {
                        System.out.println("Carta no encontrada en la colección.");
                    }
                    break;
                case 3:
                    coleccionCartas.mostrarColeccionCartas();
                    break;
                case 4:
                    coleccionCartas.mostrarColeccionCartasOrdenadaPorTipo();
                    break;
                case 5:
                    coleccionCartas.mostrarTodasLasCartas();
                    break;
                case 6:
                    coleccionCartas.mostrarTodasLasCartasOrdenadasPorTipo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
