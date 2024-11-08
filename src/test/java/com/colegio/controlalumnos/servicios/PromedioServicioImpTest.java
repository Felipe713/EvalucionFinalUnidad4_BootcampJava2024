package com.colegio.controlalumnos.servicios;

import com.colegio.controlalumnos.modelos.Materia;
import com.colegio.controlalumnos.modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PromedioServicioImpTest {

    private PromedioServicioImp promedioServicioImp;

    @BeforeEach
    public void setUp() {
        promedioServicioImp = new PromedioServicioImp();
    }

    @Test
    public void testCalcularPromedioConNotas() {
        // Crear una materia y agregar notas
        Materia materia = new Materia(MateriaEnum.MATEMATICAS);
        materia.agregarNota(5.0);
        materia.agregarNota(6.0);
        materia.agregarNota(7.0);

        // Calcular el promedio
        double promedio = promedioServicioImp.calcularPromedio(materia);
        assertEquals(6.0, promedio, 0.01, "El promedio debería ser 6.0");
    }

    @Test
    public void testCalcularPromedioSinNotas() {
        // Crear una materia sin notas
        Materia materia = new Materia(MateriaEnum.LENGUAJE);

        // Calcular el promedio
        double promedio = promedioServicioImp.calcularPromedio(materia);
        assertEquals(0.0, promedio, "El promedio debería ser 0.0 cuando no hay notas");
    }
}
