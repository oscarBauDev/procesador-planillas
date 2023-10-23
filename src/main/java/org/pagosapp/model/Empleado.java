package org.pagosapp.model;

import java.util.Objects;

public class Empleado {

    private int id;
    private String nombre;
    private float montoMensual;
    private boolean activo;

    public Empleado(int id, String nombre, float monto, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.montoMensual = monto;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMontoMensual() {
        return montoMensual;
    }

    public void setMontoMensual(float montoMensual) {
        this.montoMensual = montoMensual;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(nombre, empleado.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", montoMensual=" + montoMensual +
                ", activo=" + activo +
                '}';
    }
}
