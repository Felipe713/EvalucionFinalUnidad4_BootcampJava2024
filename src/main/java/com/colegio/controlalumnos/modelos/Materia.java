package com.colegio.controlalumnos.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas = new ArrayList<>();

    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public MateriaEnum getNombre() { return nombre; }
    public void setNombre(MateriaEnum nombre) { this.nombre = nombre; }

    public List<Double> getNotas() { return notas; }
    public void agregarNota(double nota) {
        notas.add(nota);
    }
}
