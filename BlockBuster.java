/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbusteritem;

/**
 *
 * @author balto
 */
import java.util.ArrayList;
import java.util.Scanner;

class BlockBuster {
    private ArrayList<BlockBusterItem> items;

    public BlockBuster() {
        items = new ArrayList<>();
    }

    public BlockBusterItem buscarItem(int codigo, String tipo) {
        for (BlockBusterItem item : items) {
            if (Integer.toString(codigo).equals(item.getCodigo())) {
                if ((tipo.equals("MOVIE") && item instanceof MovieItem) || 
                    (tipo.equals("GAME") && item instanceof VideoGameItem)) {
                    return item;
                }
            }
        }
        return null;
    }

    public void agregarItem(int codigo, String nombre, String tipoItem) {
        if (buscarItem(codigo, tipoItem) == null) {
            Scanner leer = new Scanner(System.in);
            if (tipoItem.equals("MOVIE")) {
                System.out.print("Ingrese el estado de la película (ESTRENO/NORMAL): ");
                String estado = leer.nextLine();
                MovieItem movie = new MovieItem(codigo, nombre,0);  
                items.add(movie);
            } else if (tipoItem.equals("GAME")) {
                System.out.print("Ingrese el tipo de consola (PLAYSTATION/XBOX/WII): ");
                String consola = leer.nextLine();
                VideoGameItem game;
                game = new VideoGameItem(codigo, nombre, consola);
                items.add(game);
            }
            System.out.println("Ítem agregado exitosamente.");
        } else {
            System.out.println("Ya existe un ítem con ese código y ese tipo.");
        }
    }

    public void rentar(int codigo, String tipoItem, int dias) {
        BlockBusterItem item = buscarItem(codigo, tipoItem);
        if (item != null) {
            System.out.println("Detalles del ítem:");
            System.out.println(item);
            double montoAPagar = item.pagoRenta(dias);
            System.out.println("Monto a pagar: Lps. " + montoAPagar);
        } else {
            System.out.println("Item No Existe");
        }
    }

    public void auditarMovieEstados() {
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem) {
                ((MovieItem) item).evaluarEstado();
            }
        }
    }
}
