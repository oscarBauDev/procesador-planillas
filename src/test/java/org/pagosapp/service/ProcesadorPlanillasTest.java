package org.pagosapp.service;

import org.junit.jupiter.api.Test;
import org.pagosapp.model.Empleado;
import org.pagosapp.provider.ProveedorMiembrosPlanilla;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProcesadorPlanillasTest {

    @Test
    void deberiaRetornarUnMontoCorrectoCincoMil(){
        ProveedorMiembrosPlanilla proveedorPlanilla = mock(ProveedorMiembrosPlanilla.class);
        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorPlanilla);

        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, "Oscar Abril", 3_000F, true),
                new Empleado(2, "Charles Baudelaire", 2_000F, true)
        );

        when(proveedorPlanilla.obtenerEmpleados()).thenReturn(empleados);

        Float montoTotalAPagar = procesadorPlanillas.obtenerMontoTotalAPagar();
        float valorEsperado = 5_000F;

        assertNotNull(montoTotalAPagar);
        assertEquals(valorEsperado, montoTotalAPagar);
    }

    @Test
    void deberiaRetornarUnMontoCorrectoDosMil(){
        ProveedorMiembrosPlanilla proveedorPlanilla = mock(ProveedorMiembrosPlanilla.class);
        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorPlanilla);

        List<Empleado> empleadosLst = Arrays.asList(
                new Empleado(1, "", 3_000F, true),
                new Empleado(2, "Charles Baudelaire", 2_000F, true),
                new Empleado(3 , "Charles Baudelaire", 2_000F, true)
        );

        Set<Empleado> empleados = new HashSet<>(empleadosLst);

        when(proveedorPlanilla.obtenerEmpleados()).thenReturn(empleados);

        Float montoTotalAPagar = procesadorPlanillas.obtenerMontoTotalAPagar();
        float valorEsperado = 2_000F;

        assertNotNull(montoTotalAPagar);
        assertEquals(valorEsperado, montoTotalAPagar);
    }

    @Test
    void deberiaRetornarUnMontoCorrectoTresMil(){
        ProveedorMiembrosPlanilla proveedorPlanilla = mock(ProveedorMiembrosPlanilla.class);
        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorPlanilla);

        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, "Oscar Abril", 3_000F, true),
                new Empleado(0, "Charles Baudelaire", 2_000F, true)
        );

        when(proveedorPlanilla.obtenerEmpleados()).thenReturn(empleados);

        Float montoTotalAPagar = procesadorPlanillas.obtenerMontoTotalAPagar();
        float valorEsperado = 3_000F;

        assertNotNull(montoTotalAPagar);
        assertEquals(valorEsperado, montoTotalAPagar);
    }

    @Test
    void deberiaRetornarCeroEmpleadosConIdCero(){
        ProveedorMiembrosPlanilla proveedorPlanilla = mock(ProveedorMiembrosPlanilla.class);
        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorPlanilla);

        List<Empleado> empleados = Arrays.asList(
                new Empleado(0, "Oscar Abril", 3_000F, true),
                new Empleado(0, "Charles Baudelaire", 2_000F, true)
        );

        when(proveedorPlanilla.obtenerEmpleados()).thenReturn(empleados);

        Float montoTotalAPagar = procesadorPlanillas.obtenerMontoTotalAPagar();
        float valorEsperado = 0F;

        assertNotNull(montoTotalAPagar);
        assertEquals(valorEsperado, montoTotalAPagar);
    }

    @Test
    void deberiaRetornarCeroEmpleadosSinNombre(){
        ProveedorMiembrosPlanilla proveedorPlanilla = mock(ProveedorMiembrosPlanilla.class);
        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorPlanilla);

        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, "", 3_000F, true),
                new Empleado(2, "", 2_000F, true)
        );

        when(proveedorPlanilla.obtenerEmpleados()).thenReturn(empleados);

        Float montoTotalAPagar = procesadorPlanillas.obtenerMontoTotalAPagar();
        float valorEsperado = 0F;

        assertNotNull(montoTotalAPagar);
        assertEquals(valorEsperado, montoTotalAPagar);
    }

    @Test
    void deberiaRetornarCeroEmpleadosConNombresNull(){
        ProveedorMiembrosPlanilla proveedorPlanilla = mock(ProveedorMiembrosPlanilla.class);
        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorPlanilla);

        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, null, 3_000F, true),
                new Empleado(2, null, 2_000F, true)
        );

        when(proveedorPlanilla.obtenerEmpleados()).thenReturn(empleados);

        Float montoTotalAPagar = procesadorPlanillas.obtenerMontoTotalAPagar();
        float valorEsperado = 0F;

        assertNotNull(montoTotalAPagar);
        assertEquals(valorEsperado, montoTotalAPagar);
    }

    @Test
    void deberiaRetornarCeroEmpleadosConMontoMensualNegativo(){
        ProveedorMiembrosPlanilla proveedorPlanilla = mock(ProveedorMiembrosPlanilla.class);
        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorPlanilla);

        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, null, -3_000F, true),
                new Empleado(2, null, -2_000F, true)
        );

        when(proveedorPlanilla.obtenerEmpleados()).thenReturn(empleados);

        Float montoTotalAPagar = procesadorPlanillas.obtenerMontoTotalAPagar();
        float valorEsperado = 0F;

        assertNotNull(montoTotalAPagar);
        assertEquals(valorEsperado, montoTotalAPagar);
    }

    @Test
    void deberiaRetornarTresMilEmpleadosInactivo(){
        ProveedorMiembrosPlanilla proveedorPlanilla = mock(ProveedorMiembrosPlanilla.class);
        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorPlanilla);

        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, "Oscar Abril", 3_000F, true),
                new Empleado(2, "Charles Baudelaire", 2_000F, false)
        );

        when(proveedorPlanilla.obtenerEmpleados()).thenReturn(empleados);

        Float montoTotalAPagar = procesadorPlanillas.obtenerMontoTotalAPagar();
        float valorEsperado = 3_000F;

        assertNotNull(montoTotalAPagar);
        assertEquals(valorEsperado, montoTotalAPagar);
    }

}