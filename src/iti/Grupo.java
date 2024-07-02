package iti;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private int id;
    private String nombre;
    private String profesor;
    private List<Alumno> alumnos;

    public Grupo(int id, String nombre, String profesor) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
        this.alumnos = new ArrayList<>();
    }
    
    public void altaAlumno(Alumno alumno) {
        if (!buscarAlumno(alumno.getId())) {
            alumnos.add(alumno);
        }
    }

    public boolean eliminarAlumno(int alumnoId) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId() == alumnoId) {
                alumnos.remove(alumno);
                return true;
            }
        }
        return false;
    }

    public boolean buscarAlumno(int alumnoId) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId() == alumnoId) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
}
