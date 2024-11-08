package com.colegio.controlalumnos.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una materia con su nombre y las notas asociadas.
 */
public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas = new ArrayList<>();

    /**
     * Constructor de la clase Materia.
     * @param nombre el nombre de la materia
     */
    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la materia.
     * @return el nombre de la materia
     */
    public MateriaEnum getNombre() { return nombre; }
    /**
     * Establece el nombre de la materia.
     * @param nombre el nombre a establecer
     */
    public void setNombre(MateriaEnum nombre) { this.nombre = nombre; }

    /**
     * Obtiene la lista de notas de la materia.
     * @return lista de notas
     */
    public List<Double> getNotas() { return notas; }
    /**
     * Agrega una nota a la lista de notas de la materia.
     * @param nota la nota a agregar
     */
    public void agregarNota(double nota) {
        notas.add(nota);
    }
}
