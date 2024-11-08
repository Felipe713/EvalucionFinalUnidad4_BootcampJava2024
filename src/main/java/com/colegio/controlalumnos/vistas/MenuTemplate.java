package com.colegio.controlalumnos.vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    // Método plantilla para iniciar el menú
    public void iniciarMenu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            ejecutarOpcion(opcion);
        } while (opcion != obtenerOpcionSalir());
    }

    // Métodos abstractos que las clases derivadas deben implementar
    protected abstract void mostrarOpciones();
    protected abstract void ejecutarOpcion(int opcion);
    protected abstract int obtenerOpcionSalir();

    // Métodos base para las opciones del menú, que pueden ser sobrescritos en las clases derivadas
    public void crearAlumno() {
        System.out.println("Función para crear alumno no implementada.");
    }

    public void agregarMateria() {
        System.out.println("Función para agregar materia no implementada.");
    }

    public void agregarNota() {
        System.out.println("Función para agregar nota no implementada.");
    }

    public void listarAlumnos() {
        System.out.println("Función para listar alumnos no implementada.");
    }

    public void exportarDatos() {
        System.out.println("Función para exportar datos no implementada.");
    }
}
