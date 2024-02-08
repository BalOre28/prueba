/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbusteritem;

/**
 *
 * @author balto
 */
class VideoGameItem extends BlockBusterItem {
    private String consola;
    private static final String PLAYSTATION = "PLAYSTATION";
    private static final String XBOX = "XBOX";
    private static final String WII = "WII";

    public VideoGameItem(int code, String name, String consola) {
        super(code, name, 30); // El precio de Lps. 30
        if (esConsolaValida(consola)) {
            this.consola = consola;
        } else {
            throw new IllegalArgumentException("Consola no válida");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - " + consola + " - Game";
    }

    @Override
    public double pagoRenta(int dias) {
        return super.getPrecio() * dias;
    }

    private boolean esConsolaValida(String consola) {
        return consola.equals(PLAYSTATION) || consola.equals(XBOX) || consola.equals(WII);
    }
}

