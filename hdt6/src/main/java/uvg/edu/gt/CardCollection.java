package uvg.edu.gt;

import java.util.Map;

interface CardCollection {
    void agregarCarta(String nombreCarta, String tipoCarta);
    String obtenerTipoCarta(String nombreCarta);
    Map<String, Integer> obtenerColeccionCartas();
    void mostrarColeccionCartas();
    void mostrarColeccionCartasOrdenadaPorTipo();
    void mostrarTodasLasCartas();
    void mostrarTodasLasCartasOrdenadasPorTipo();
}