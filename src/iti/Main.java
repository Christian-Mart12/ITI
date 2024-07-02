package iti;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SistemaDeGrupos sistema = new SistemaDeGrupos();
        Scanner scanner = new Scanner(System.in);
        char opc;

        do {
            System.out.println("\nMenú:");
            System.out.println("a. Crear un nuevo grupo");
            System.out.println("b. Consultar un grupo por su ID");
            System.out.println("c. Eliminar un grupo (solo si no tiene alumnos inscritos)");
            System.out.println("d. Registrar a un alumno");
            System.out.println("e. Inscribir a un alumno en un grupo (validando que no esté ya inscrito en otro grupo)");
            System.out.println("f. Desinscribir a un alumno de un grupo");
            System.out.println("g. Salir");
            System.out.print("Selecciona una opción: ");
            opc = scanner.next().charAt(0);
            scanner.nextLine();  // Limpiar el buffer

            switch (opc) {
                case 'a':
                    System.out.print("ID del grupo: ");
                    int idGrupo = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = scanner.nextLine();
                    System.out.print("Nombre del profesor: ");
                    String profesor = scanner.nextLine();
                    sistema.crearGrupo(idGrupo, nombreGrupo, profesor);
                    break;

                case 'b':
                    System.out.print("ID del grupo a consultar: ");
                    idGrupo = scanner.nextInt();
                    Grupo grupo = sistema.consultarGrupoPorId(idGrupo);
                    if (grupo != null) {
                        System.out.println("Grupo encontrado: " + grupo.getNombre() + ", Profesor: " + grupo.getProfesor());
                        System.out.println("Alumnos inscritos:");
                        for (Alumno alumno : grupo.getAlumnos()) {
                            System.out.println("- " + alumno.getNombre() + " (ID: " + alumno.getId() + ")");
                        }
                    } else {
                        System.out.println("Grupo no encontrado.");
                    }
                    break;

                case 'c':
                    System.out.print("ID del grupo a eliminar: ");
                    idGrupo = scanner.nextInt();
                    boolean eliminado = sistema.eliminarGrupo(idGrupo);
                    if (eliminado) {
                        System.out.println("Grupo eliminado exitosamente.");
                    } else {
                        System.out.println("No se pudo eliminar el grupo (puede tener alumnos inscritos o no existir).");
                    }
                    break;

                case 'd':
                    System.out.print("ID del alumno: ");
                    int idAlumno = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Nombre del alumno: ");
                    String nombreAlumno = scanner.nextLine();
                    System.out.print("Edad del alumno: ");
                    int edad = scanner.nextInt();
                    sistema.registrarAlumno(idAlumno, nombreAlumno, edad);
                    break;

                case 'e':
                    System.out.print("ID del alumno a inscribir: ");
                    idAlumno = scanner.nextInt();
                    System.out.print("ID del grupo: ");
                    idGrupo = scanner.nextInt();
                    boolean inscrito = sistema.inscribirAlumnoEnGrupo(idAlumno, idGrupo);
                    if (inscrito) {
                        System.out.println("Alumno inscrito exitosamente.");
                    } else {
                        System.out.println("No se pudo inscribir al alumno (puede estar ya inscrito en otro grupo, no estar registrado o el grupo no existir).");
                    }
                    break;

                case 'f':
                    System.out.print("ID del alumno a desinscribir: ");
                    idAlumno = scanner.nextInt();
                    System.out.print("ID del grupo: ");
                    idGrupo = scanner.nextInt();
                    boolean desinscrito = sistema.desinscribirAlumnoDeGrupo(idAlumno, idGrupo);
                    if (desinscrito) {
                        System.out.println("Alumno desinscrito exitosamente.");
                    } else {
                        System.out.println("No se pudo desinscribir al alumno (puede no estar inscrito en el grupo o el grupo no existir).");
                    }
                    break;

                case 'g':
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opc != 'g');

        scanner.close();
    }
}
