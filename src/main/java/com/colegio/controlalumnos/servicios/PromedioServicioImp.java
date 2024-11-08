package com.colegio.controlalumnos.servicios;

import com.colegio.controlalumnos.modelos.Materia;
import java.util.List;

/**
 * Implementación del servicio para calcular el promedio de las notas de una materia.
 */
public class PromedioServicioImp {

    /**
     * Calcula el promedio de las notas en una materia.
     * @param materia la materia de la cual se calcula el promedio
     * @return el promedio de las notas, o 0 si no hay notas
     */
    public double calcularPromedio(Materia materia) {
        List<Double> notas = materia.getNotas();
        if (notas.isEmpty()) return 0.0;

        double suma = 0.0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}
