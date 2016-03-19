/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desvanmika;

import java.util.GregorianCalendar;

/**
 *
 * @author Josete
 */
public class Pedido {
 private int nPedido;
 private GregorianCalendar Fecha_pedido;
 private GregorianCalendar Fecha_entrega;
 private double Precio;
 private int cliente;
 // la clave ajena seria idcliente de la clase cliente

    public Pedido(int nPedido, GregorianCalendar Fecha_pedido, GregorianCalendar Fecha_entrega, double Precio) {
        this.nPedido = nPedido;
        this.Fecha_pedido = Fecha_pedido;
        this.Fecha_entrega = Fecha_entrega;
        this.Precio = Precio;
    }

    public int getnPedido() {
        return nPedido;
    }

    public void setnPedido(int nPedido) {
        this.nPedido = nPedido;
    }

    public GregorianCalendar getFecha_pedido() {
        return Fecha_pedido;
    }

    public void setFecha_pedido(GregorianCalendar Fecha_pedido) {
        this.Fecha_pedido = Fecha_pedido;
    }

    public GregorianCalendar getFecha_entrega() {
        return Fecha_entrega;
    }

    public void setFecha_entrega(GregorianCalendar Fecha_entrega) {
        this.Fecha_entrega = Fecha_entrega;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
 
 
}
