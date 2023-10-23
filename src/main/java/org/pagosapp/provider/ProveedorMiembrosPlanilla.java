package org.pagosapp.provider;

import org.pagosapp.model.Empleado;

import java.util.Collection;

public interface ProveedorMiembrosPlanilla {

    Collection<Empleado> obtenerEmpleados();
}
