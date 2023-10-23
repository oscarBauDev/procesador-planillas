package org.pagosapp.service;

import org.pagosapp.provider.ProveedorMiembrosPlanilla;
import org.pagosapp.model.Empleado;

import java.util.Collection;

public class ProcesadorPlanillas {

    private ProveedorMiembrosPlanilla proovedorPlanillas;

    public ProcesadorPlanillas(ProveedorMiembrosPlanilla proovedorPlanillas) {
        this.proovedorPlanillas = proovedorPlanillas;
    }

    public float obtenerMontoTotalAPagar(){
        Collection<Empleado> empleados = proovedorPlanillas.obtenerEmpleados();
        return empleados.stream()
                .filter(empleado -> empleado.getId() > 0
                        && empleado.getNombre() != null
                        && !empleado.getNombre().trim().isEmpty()
                        && empleado.getMontoMensual() > 0L
                        && empleado.getActivo() == true)
                .map(empleado -> empleado.getMontoMensual())
                .reduce(0F, Float::sum);
    }

}
