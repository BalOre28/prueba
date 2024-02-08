/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbusteritem;

import java.util.Calendar;

/**
 *
 * @author balto
 */
public class MovieItem extends BlockBusterItem{
    private String estado;
    
    public MovieItem(int code,String name,double precio){
        super(code,name,precio);
        estado=" ESTRENO";
    }
    
    public String toString(){
        return super.toString()+" "+estado+", Movie";
    }
    
    public double pagoRenta(int dias){
        double pagoTotal = super.getPrecio();

        if (estado.equals("ESTRENO") && dias > 2) {
            pagoTotal += 50 * (dias - 2);
        } else if (estado.equals("NORMAL") && dias > 5) {
            pagoTotal += 30 * (dias - 5);
        }

        return pagoTotal;
    }
    
    public void evaluarEstado(){
         Calendar fechaActual = Calendar.getInstance();
        Calendar fechaAdicion = Calendar.getInstance();

        fechaAdicion.add(Calendar.MONTH, 5);
        
         
        if (fechaActual.after(fechaAdicion) && estado.equals("ESTRENO")) {
            estado = "NORMAL";
        }
    }
}
