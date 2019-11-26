/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.sistemas.entity;

/**
 *
 * @author jorge
 */
public class Empleado {
    
    private int codigo;
    private String nombre;
    private String cargo;
    private String area;
    private double sueldo;
    private double descuento;
    private double sueldo_neto;

    public Empleado() {
    }

    public Empleado(String nombre, String cargo, String area, int sueldo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.area = area;
        this.sueldo = sueldo;
        
        if (this.sueldo >= 1800){
            this.descuento = 0.08*this.sueldo;
    
        } else {
            this.descuento = 0;
        }
        
        this.sueldo_neto = this.sueldo - this.descuento;
    }

    
    
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
        
        if (this.sueldo >= 1800){
            this.descuento = 0.08*this.sueldo;
    
        } else {
            this.descuento = 0;
        }
        this.sueldo_neto = this.sueldo - this.descuento;

        
    }

    public double getDescuento() {

        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSueldo_neto() {
        return sueldo_neto;
    }

    public void setSueldo_neto(double sueldo_neto) {
        this.sueldo_neto = sueldo_neto;
    }
  
    
}
