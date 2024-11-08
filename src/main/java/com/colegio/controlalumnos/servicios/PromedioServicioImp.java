package com.colegio.controlalumnos.servicios;

import com.colegio.controlalumnos.modelos.Materia;
import java.util.List;

public class PromedioServicioImp {

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
