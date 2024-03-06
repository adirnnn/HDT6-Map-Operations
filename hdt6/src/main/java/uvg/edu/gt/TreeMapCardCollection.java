package uvg.edu.gt;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapCardCollection implements CardCollection {
    // Mapa para almacenar el tipo de cada carta, ordenado por clave (nombre de la carta)
    private final Map<String, String> tiposCartas;
    // Mapa para almacenar la cantidad de cada carta en la colección, ordenado por clave (nombre de la carta)
    private final Map<String, Integer> coleccionCartas;

    // Constructor para inicializar los mapas
    public TreeMapCardCollection() {
        this.tiposCartas = new TreeMap<>();
        this.coleccionCartas = new TreeMap<>();
    }

    // Método para agregar una carta a la colección
    @Override
    public void agregarCarta(String nombreCarta, String tipoCarta) {
        // Incrementar la cantidad de la carta en la colección
        coleccionCartas.put(nombreCarta, coleccionCartas.getOrDefault(nombreCarta, 0) + 1);
        // Almacenar el tipo de carta
        tiposCartas.put(nombreCarta, tipoCarta);
    }

    // Método para obtener el tipo de una carta específica
    @Override
    public String obtenerTipoCarta(String nombreCarta) {
        return tiposCartas.get(nombreCarta);
    }

    // Método para obtener la colección completa de cartas
    @Override
    public Map<String, Integer> obtenerColeccionCartas() {
        return coleccionCartas;
    }

    // Método para mostrar la colección de cartas con su tipo y cantidad
    @Override
    public void mostrarColeccionCartas() {
        System.out.println("Colección de Cartas:");
        for (Map.Entry<String, Integer> entrada : coleccionCartas.entrySet()) {
            String nombreCarta = entrada.getKey();
            String tipoCarta = tiposCartas.get(nombreCarta);
            int cantidad = entrada.getValue();
            System.out.println(nombreCarta + " - Tipo: " + tipoCarta + " - Cantidad: " + cantidad);
        }
    }

    // Método para mostrar la colección de cartas ordenada por tipo
    @Override
    public void mostrarColeccionCartasOrdenadaPorTipo() {
        System.out.println("Colección de Cartas ordenada por Tipo:");
        tiposCartas.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entrada -> {
                    String nombreCarta = entrada.getKey();
                    String tipoCarta = entrada.getValue();
                    int cantidad = coleccionCartas.getOrDefault(nombreCarta, 0);
                    System.out.println(nombreCarta + " - Tipo: " + tipoCarta + " - Cantidad: " + cantidad);
                });
    }

    // Método para mostrar todas las cartas con su tipo
    @Override
    public void mostrarTodasLasCartas() {
        System.out.println("Todas las Cartas:");
        for (Map.Entry<String, String> entrada : tiposCartas.entrySet()) {
            String nombreCarta = entrada.getKey();
            String tipoCarta = entrada.getValue();
            System.out.println(nombreCarta + " - Tipo: " + tipoCarta);
        }
    }

    // Método para mostrar todas las cartas ordenadas por tipo
    @Override
    public void mostrarTodasLasCartasOrdenadasPorTipo() {
        System.out.println("Todas las Cartas ordenadas por Tipo:");
        tiposCartas.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entrada -> {
                    String nombreCarta = entrada.getKey();
                    String tipoCarta = entrada.getValue();
                    System.out.println(nombreCarta + " - Tipo: " + tipoCarta);
                });
    }
}
