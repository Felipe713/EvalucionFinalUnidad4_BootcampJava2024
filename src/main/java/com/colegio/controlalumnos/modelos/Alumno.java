package com.colegio.controlalumnos.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un alumno con sus datos personales y las materias asignadas.
 */
public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> materias = new ArrayList<>();


    /**
     * Obtiene el RUT del alumno.
     * @return el RUT del alumno
     */
    public String getRut() { return rut; }
    /**
     * Establece el RUT del alumno.
     * @param rut el RUT a establecer
     */
    public void setRut(String rut) { this.rut = rut; }

    /**
     * Obtiene el nombre del alumno.
     * @return el nombre del alumno
     */
    public String getNombre() { return nombre; }
    /**
     * Establece el nombre del alumno.
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene el apellido del alumno.
     * @return el apellido del alumno
     */
    public String getApellido() { return apellido; }

    /**
     * Establece el apellido del alumno.
     * @param apellido el apellido a establecer
     */
    public void setApellido(String apellido) { this.apellido = apellido; }

    /**
     * Obtiene la dirección del alumno.
     * @return la dirección del alumno
     */
    public String getDireccion() { return direccion; }
    /**
     * Establece la dirección del alumno.
     * @param direccion la dirección a establecer
     */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /**
     * Obtiene la lista de materias del alumno.
     * @return lista de materias
     */
    public List<Materia> getMaterias() { return materias; }
    /**
     * Agrega una materia a la lista de materias del alumno.
     * @param materia la materia a agregar
     */
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }
}
