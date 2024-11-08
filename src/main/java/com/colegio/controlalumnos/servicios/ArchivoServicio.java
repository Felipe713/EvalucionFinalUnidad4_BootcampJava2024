package com.colegio.controlalumnos.servicios;

import com.colegio.controlalumnos.modelos.Alumno;
import com.colegio.controlalumnos.modelos.Materia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Servicio para exportar datos de alumnos a un archivo.
 */
public class ArchivoServicio {

    /**
     * Exporta los datos de los alumnos a un archivo en la ruta especificada.
     * @param alumnos mapa de alumnos a exportar
     * @param ruta la ruta del archivo de destino
     */
    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        File archivo = new File(ruta);
        File carpeta = archivo.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido());
                writer.newLine();

                for (Materia materia : alumno.getMaterias()) {
                    // Calcular el promedio de la materia
                    double promedio = calcularPromedio(materia);
                    writer.write("  Materia: " + materia.getNombre() + " - Notas: " + materia.getNotas() + " - Promedio: " + promedio);
                    writer.newLine();
                }
                writer.newLine();
            }
            System.out.println("Datos exportados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    // Método para calcular el promedio de una materia
    private double calcularPromedio(Materia materia) {
        if (materia.getNotas().isEmpty()) {
            return 0.0;
        }

        double suma = 0;
        for (double nota : materia.getNotas()) {
            suma += nota;
        }
        return suma / materia.getNotas().size();
    }
}
