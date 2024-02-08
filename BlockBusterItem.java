/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blockbusteritem;

import java.util.Calendar;

/**
 *
 * @author balto
 */
public abstract class BlockBusterItem {
    private int codigo;
    private String nombre;
    private double precio;
    private Calendar fecha;
    
    public BlockBusterItem(int code, String name, double precioRenta) {
        codigo = code;
        nombre = name;
        precio= precioRenta;
        fecha = Calendar.getInstance();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
     public String toString() {
        return "Código: " + codigo +", Nombre: " + nombre+", Precio de renta: " + precio+" Lps.";
    }
    public abstract double pagoRenta(int dias);
}
