package com.colegio.controlalumnos.servicios;

import com.colegio.controlalumnos.modelos.Alumno;
import com.colegio.controlalumnos.modelos.Materia;
import com.colegio.controlalumnos.modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoServicioTest {

    private AlumnoServicio alumnoServicio;

    @BeforeEach
    public void setUp() {
        alumnoServicio = new AlumnoServicio();
    }

    @Test
    public void testCrearAlumno() {
        // Crear un alumno usando el nuevo método sin interacción
        alumnoServicio.crearAlumno("1.111.111-1", "Juan", "Pérez", "Calle Falsa 123");

        // Verificar que el alumno fue agregado
        assertFalse(alumnoServicio.getListaAlumnos().isEmpty(), "La lista de alumnos no debería estar vacía");
        assertTrue(alumnoServicio.getListaAlumnos().containsKey("1.111.111-1"), "Debería contener el alumno con el RUT dado");
        assertEquals("Juan", alumnoServicio.getListaAlumnos().get("1.111.111-1").getNombre(), "El nombre del alumno debería ser 'Juan'");
    }


    @Test
    public void testAgregarMateria() {
        // Crear un alumno manualmente
        Alumno alumno = new Alumno();
        alumno.setRut("1.111.111-1");
        alumnoServicio.getListaAlumnos().put(alumno.getRut(), alumno);

        // Agregar una materia usando el nuevo método sin interacción
        alumnoServicio.agregarMateria(alumno.getRut(), MateriaEnum.MATEMATICAS);

        // Verificar que la materia fue agregada
        assertFalse(alumno.getMaterias().isEmpty(), "La lista de materias no debería estar vacía");
        assertEquals(MateriaEnum.MATEMATICAS, alumno.getMaterias().get(0).getNombre(), "La materia debería ser Matemáticas");
    }

    @Test
    public void testAgregarNota() {
        // Crear un alumno y agregar una materia manualmente
        Alumno alumno = new Alumno();
        alumno.setRut("1.111.111-1");
        Materia materia = new Materia(MateriaEnum.MATEMATICAS);
        alumno.agregarMateria(materia);
        alumnoServicio.getListaAlumnos().put(alumno.getRut(), alumno);

        // Agregar una nota
        alumnoServicio.agregarNota(alumno.getRut(), MateriaEnum.MATEMATICAS, 6.5);
        assertFalse(materia.getNotas().isEmpty(), "La lista de notas no debería estar vacía");
        assertEquals(6.5, materia.getNotas().get(0), "La nota debería ser 6.5");
    }
}
