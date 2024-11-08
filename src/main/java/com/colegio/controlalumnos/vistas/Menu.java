package com.colegio.controlalumnos.vistas;

import com.colegio.controlalumnos.modelos.MateriaEnum;
import com.colegio.controlalumnos.servicios.AlumnoServicio;
import com.colegio.controlalumnos.servicios.ArchivoServicio;

import java.util.Scanner;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();
    private Scanner scanner = new Scanner(System.in);

    @Override
    protected void mostrarOpciones() {
        System.out.println("AL EJECUTAR EL MENÚ:");
        System.out.println("1. Crear Alumno");
        System.out.println("2. Listar Alumnos");
        System.out.println("3. Agregar Materia");
        System.out.println("4. Agregar Nota");
        System.out.println("5. Salir");
        System.out.println("6. Exportar Datos");
        System.out.print("Selección: ");
    }

    @Override
    protected void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearAlumno();
                break;
            case 2:
                listarAlumnos();
                break;
            case 3:
                seleccionarMateriaParaAgregar();
                break;
            case 4:
                seleccionarNotaParaAgregar();
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            case 6:
                exportarDatos();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    @Override
    protected int obtenerOpcionSalir() {
        return 5;
    }

    @Override
    public void crearAlumno() {
        alumnoServicio.crearAlumno();
    }

    public void listarAlumnos() {
        alumnoServicio.listarAlumnos();
    }

    public void seleccionarMateriaParaAgregar() {
        System.out.print("Ingresa RUT del alumno: ");
        String rut = scanner.nextLine();

        System.out.println("Selecciona una Materia:");
        for (MateriaEnum materiaEnum : MateriaEnum.values()) {
            System.out.println((materiaEnum.ordinal() + 1) + ". " + materiaEnum);
        }

        int opcionMateria = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcionMateria >= 1 && opcionMateria <= MateriaEnum.values().length) {
            MateriaEnum materiaSeleccionada = MateriaEnum.values()[opcionMateria - 1];
            alumnoServicio.agregarMateria(rut, materiaSeleccionada);
        } else {
            System.out.println("Opción de materia no válida.");
        }
    }

    public void seleccionarNotaParaAgregar() {
        System.out.print("Ingresa RUT del alumno: ");
        String rut = scanner.nextLine();

        // Obtener el alumno y verificar si tiene materias
        var alumno = alumnoServicio.getListaAlumnos().get(rut);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        if (alumno.getMaterias().isEmpty()) {
            System.out.println("El alumno no tiene materias asignadas. Agrega una materia primero.");
            return;
        }

        // Mostrar las materias del alumno y seleccionar una para agregar nota
        System.out.println("--- Agregar Nota ---");
        System.out.println("Alumno tiene las siguientes materias agregadas:");
        int index = 1;
        for (var materia : alumno.getMaterias()) {
            System.out.println(index++ + ". " + materia.getNombre());
        }

        System.out.print("Selecciona una Materia: ");
        int opcionMateria = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Validar la opción de materia seleccionada
        if (opcionMateria < 1 || opcionMateria > alumno.getMaterias().size()) {
            System.out.println("Opción de materia no válida.");
            return;
        }

        // Obtener la materia seleccionada
        var materiaSeleccionada = alumno.getMaterias().get(opcionMateria - 1);

        // Solicitar la nota a agregar
        System.out.print("Ingresa la nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        // Agregar la nota a la materia y mostrar mensaje
        materiaSeleccionada.agregarNota(nota);
        System.out.println("Nota " + nota + " agregada a la materia " + materiaSeleccionada.getNombre());
    }

    public void exportarDatos() {
        System.out.print("Ingresa la ruta completa del archivo (incluye el nombre y extensión del archivo): ");
        String ruta = scanner.nextLine();
        archivoServicio.exportarDatos(alumnoServicio.getListaAlumnos(), ruta);
    }
}
