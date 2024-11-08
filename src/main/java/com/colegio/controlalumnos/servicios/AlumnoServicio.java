package com.colegio.controlalumnos.servicios;

import com.colegio.controlalumnos.modelos.Alumno;
import com.colegio.controlalumnos.modelos.Materia;
import com.colegio.controlalumnos.modelos.MateriaEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // Método para crear un alumno con entrada desde consola
    public void crearAlumno() {
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();

        Alumno alumno = new Alumno();
        alumno.setRut(rut);
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDireccion(direccion);

        listaAlumnos.put(rut, alumno);
        System.out.println("¡Alumno agregado!");
    }

    // Método para listar alumnos registrados
    public void listarAlumnos() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        for (Alumno alumno : listaAlumnos.values()) {
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("Materias:");
            for (Materia materia : alumno.getMaterias()) {
                System.out.println("  - " + materia.getNombre() + ": Notas " + materia.getNotas());
            }
            System.out.println();
        }
    }

    // Método para agregar una materia a un alumno con entrada desde consola
    public void agregarMateria(String rut) {
        Alumno alumno = listaAlumnos.get(rut);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        System.out.println("Selecciona una Materia:");
        for (MateriaEnum materiaEnum : MateriaEnum.values()) {
            System.out.println((materiaEnum.ordinal() + 1) + ". " + materiaEnum);
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion < 1 || opcion > MateriaEnum.values().length) {
            System.out.println("Opción no válida.");
            return;
        }

        MateriaEnum materiaSeleccionada = MateriaEnum.values()[opcion - 1];
        Materia materia = new Materia(materiaSeleccionada);
        alumno.agregarMateria(materia);
        System.out.println("¡Materia agregada a " + alumno.getNombre() + "!");
    }

    // Método para agregar una nota a una materia específica de un alumno
    public void agregarNota(String rut, MateriaEnum materiaEnum, double nota) {
        Alumno alumno = listaAlumnos.get(rut);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        for (Materia materia : alumno.getMaterias()) {
            if (materia.getNombre() == materiaEnum) {
                materia.agregarNota(nota);
                System.out.println("¡Nota " + nota + " agregada a la materia " + materia.getNombre() + " de " + alumno.getNombre() + "!");
                return;
            }
        }
        System.out.println("Materia no encontrada.");
    }

    // Método para obtener la lista de alumnos (para otros métodos)
    public Map<String, Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    // Sobrecarga de agregarMateria para agregar directamente sin interacción de consola
    public void agregarMateria(String rut, MateriaEnum materiaEnum) {
        Alumno alumno = listaAlumnos.get(rut);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        Materia materia = new Materia(materiaEnum);
        alumno.agregarMateria(materia);
        System.out.println("¡Materia " + materiaEnum + " agregada a " + alumno.getNombre() + "!");
    }

    // Sobrecarga de crearAlumno para agregar un alumno sin interacción de consola
    public void crearAlumno(String rut, String nombre, String apellido, String direccion) {
        Alumno alumno = new Alumno();
        alumno.setRut(rut);
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDireccion(direccion);

        listaAlumnos.put(rut, alumno);
        System.out.println("¡Alumno agregado con éxito!");
    }
}
