package gestionestudiantes;

import java.util.ArrayList;

/**
 * Clase que representa un Curso que contiene múltiples estudiantes
 * Demuestra el uso de colecciones y métodos para gestionar grupos de objetos
 */
public class Curso {
    // Atributos de la clase
    private String nombreCurso;
    private String codigoCurso;
    private ArrayList<Estudiante> listaEstudiantes;
    
    /**
     * Constructor de la clase Curso
     * @param nombreCurso Nombre del curso
     * @param codigoCurso Código identificador del curso
     */
    public Curso(String nombreCurso, String codigoCurso) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.listaEstudiantes = new ArrayList<>();
    }
    
    // Métodos Getters
    public String getNombreCurso() {
        return nombreCurso;
    }
    
    public String getCodigoCurso() {
        return codigoCurso;
    }
    
    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    
    /**
     * Método para agregar un estudiante al curso
     * @param estudiante Objeto Estudiante a agregar
     */
    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
        System.out.println("Estudiante " + estudiante.getNombreCompleto() + " agregado al curso.");
    }
    
    /**
     * Método para eliminar un estudiante del curso por código
     * @param codigo Código del estudiante a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarEstudiante(String codigo) {
        for (Estudiante est : listaEstudiantes) {
            if (est.getCodigo().equals(codigo)) {
                listaEstudiantes.remove(est);
                System.out.println("Estudiante con código " + codigo + " eliminado.");
                return true;
            }
        }
        System.out.println("No se encontró estudiante con código " + codigo);
        return false;
    }
    
    /**
     * Método para buscar un estudiante por código
     * @param codigo Código del estudiante a buscar
     * @return Objeto Estudiante si se encuentra, null si no existe
     */
    public Estudiante buscarEstudiante(String codigo) {
        for (Estudiante est : listaEstudiantes) {
            if (est.getCodigo().equals(codigo)) {
                return est;
            }
        }
        return null;
    }
    
    /**
     * Método para calcular el promedio general del curso
     * @return Promedio general de todos los estudiantes
     */
    public double calcularPromedioGeneral() {
        if (listaEstudiantes.isEmpty()) {
            return 0.0;
        }
        
        double suma = 0;
        for (Estudiante est : listaEstudiantes) {
            suma += est.getPromedio();
        }
        return suma / listaEstudiantes.size();
    }
    
    /**
     * Método para mostrar todos los estudiantes del curso
     */
    public void mostrarEstudiantes() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes inscritos en el curso.");
            return;
        }
        
        System.out.println("\n=== LISTA DE ESTUDIANTES - " + nombreCurso.toUpperCase() + " ===");
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            System.out.println("\nEstudiante #" + (i + 1) + ":");
            System.out.println(listaEstudiantes.get(i).toString());
            System.out.println("-------------------");
        }
    }
    
    /**
     * Método para contar estudiantes sobresalientes
     * @return Cantidad de estudiantes con promedio >= 4.0
     */
    public int contarSobresalientes() {
        int count = 0;
        for (Estudiante est : listaEstudiantes) {
            if (est.esSobresaliente()) {
                count++;
            }
        }
        return count;
    }
}
