package uvg.edu.gt;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapCardCollection implements CardCollection {
    private final Map<String, String> tiposCartas;
    private final Map<String, Integer> coleccionCartas;

    public TreeMapCardCollection() {
        this.tiposCartas = new TreeMap<>();
        this.coleccionCartas = new TreeMap<>();
    }

    @Override
    public void agregarCarta(String nombreCarta, String tipoCarta) {
        coleccionCartas.put(nombreCarta, coleccionCartas.getOrDefault(nombreCarta, 0) + 1);
        tiposCartas.put(nombreCarta, tipoCarta);
    }

    @Override
    public String obtenerTipoCarta(String nombreCarta) {
        return tiposCartas.get(nombreCarta);
    }

    @Override
    public Map<String, Integer> obtenerColeccionCartas() {
        return coleccionCartas;
    }

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

    @Override
    public void mostrarTodasLasCartas() {
        System.out.println("Todas las Cartas:");
        for (Map.Entry<String, String> entrada : tiposCartas.entrySet()) {
            String nombreCarta = entrada.getKey();
            String tipoCarta = entrada.getValue();
            System.out.println(nombreCarta + " - Tipo: " + tipoCarta);
        }
    }

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