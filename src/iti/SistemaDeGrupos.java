package iti;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeGrupos {
    private List<Grupo> grupos;
    private List<Alumno> alumnos;

    public SistemaDeGrupos() {
        this.grupos = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    public void crearGrupo(int id, String nombre, String profesor) {
        if (buscarGrupoPorId(id) == null) {
            grupos.add(new Grupo(id, nombre, profesor));
        } else {
            System.out.println("El grupo con ID " + id + " ya existe.");
        }
    }

    public Grupo consultarGrupoPorId(int id) {
        return buscarGrupoPorId(id);
    }

    public boolean eliminarGrupo(int id) {
        Grupo grupo = buscarGrupoPorId(id);
        if (grupo != null && grupo.getAlumnos().isEmpty()) {
            grupos.remove(grupo);
            return true;
        }
        return false;
    }

    public void registrarAlumno(int id, String nombre, int edad) {
        if (buscarAlumnoPorId(id) == null) {
            alumnos.add(new Alumno(id, nombre, edad));
        } else {
            System.out.println("El alumno con ID " + id + " ya está registrado.");
        }
    }

    public boolean inscribirAlumnoEnGrupo(int alumnoId, int grupoId) {
        Alumno alumno = buscarAlumnoPorId(alumnoId);
        Grupo grupo = buscarGrupoPorId(grupoId);

        if (alumno == null) {
            System.out.println("El alumno con ID " + alumnoId + " no está registrado.");
            return false;
        }

        if (grupo == null) {
            System.out.println("El grupo con ID " + grupoId + " no existe.");
            return false;
        }

        for (Grupo g : grupos) {
            if (g.buscarAlumno(alumnoId)) {
                System.out.println("El alumno con ID " + alumnoId + " ya está inscrito en otro grupo.");
                return false;
            }
        }

        grupo.altaAlumno(alumno);
        return true;
    }

    public boolean desinscribirAlumnoDeGrupo(int alumnoId, int grupoId) {
        Grupo grupo = buscarGrupoPorId(grupoId);
        if (grupo != null) {
            return grupo.eliminarAlumno(alumnoId);
        }
        return false;
    }

    private Grupo buscarGrupoPorId(int id) {
        for (Grupo grupo : grupos) {
            if (grupo.getId() == id) {
                return grupo;
            }
        }
        return null;
    }

    private Alumno buscarAlumnoPorId(int id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId() == id) {
                return alumno;
            }
        }
        return null;
    }
}
