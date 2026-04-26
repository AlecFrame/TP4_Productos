package com.vertacnik.tp4_productos.ui.model;

public class Producto {
    private String codigo;
    private String desc;
    private double precio;

    public Producto() {}

    public Producto(String codigo, String desc, double precio) {
        this.codigo = codigo;
        this.desc = desc;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
