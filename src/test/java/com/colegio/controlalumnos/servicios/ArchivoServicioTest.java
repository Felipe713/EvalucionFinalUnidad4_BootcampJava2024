package com.colegio.controlalumnos.servicios;

import com.colegio.controlalumnos.modelos.Alumno;
import com.colegio.controlalumnos.modelos.Materia;
import com.colegio.controlalumnos.modelos.MateriaEnum;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArchivoServicioTest {

    private ArchivoServicio archivoServicio = new ArchivoServicio();

    @Test
    public void testExportarDatos() throws IOException {
        // Preparar datos de prueba
        Map<String, Alumno> alumnos = new HashMap<>();
        Alumno alumno = new Alumno();
        alumno.setRut("1.111.111-1");
        alumno.setNombre("Juan");
        alumno.agregarMateria(new Materia(MateriaEnum.MATEMATICAS));
        alumnos.put(alumno.getRut(), alumno);

        // Nombre del archivo de prueba
        String rutaArchivo = "alumnos_test.txt";

        // Ejecutar el método de exportación
        archivoServicio.exportarDatos(alumnos, rutaArchivo);

        // Verificar que el archivo fue creado
        File archivo = new File(rutaArchivo);
        assertTrue(archivo.exists(), "El archivo debería haber sido creado");

        // Limpiar el archivo de prueba
        Files.deleteIfExists(archivo.toPath());
    }
}
