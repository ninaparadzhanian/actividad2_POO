package gestionestudiantes;

import java.util.ArrayList;

/**
 * Clase que representa un Curso que contiene múltiples estudiantes
 * Ahora puede manejar diferentes tipos de estudiantes gracias a la herencia
 */
public class Curso {
    private String nombreCurso;
    private String codigoCurso;
    private ArrayList<Estudiante> listaEstudiantes;
    
    public Curso(String nombreCurso, String codigoCurso) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.listaEstudiantes = new ArrayList<>();
    }
    
    // Getters
    public String getNombreCurso() { return nombreCurso; }
    public String getCodigoCurso() { return codigoCurso; }
    public ArrayList<Estudiante> getListaEstudiantes() { return listaEstudiantes; }
    
    /**
     * Método para agregar cualquier tipo de Estudiante (gracias a la herencia)
     */
    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
        System.out.println("Estudiante " + estudiante.getNombreCompleto() + 
                          " (" + estudiante.getTipoEstudiante() + ") agregado al curso.");
    }
    
    /**
     * Método para eliminar un estudiante del curso por código
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
     * Ahora muestra información específica de cada tipo de estudiante
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
    
    /**
     * NUEVO: Método para contar estudiantes por tipo
     */
    public void mostrarEstadisticasPorTipo() {
        int pregrado = 0, posgrado = 0, intercambio = 0;
        
        for (Estudiante est : listaEstudiantes) {
            if (est instanceof EstudiantePregrado) {
                pregrado++;
            } else if (est instanceof EstudiantePosgrado) {
                posgrado++;
            } else if (est instanceof EstudianteIntercambio) {
                intercambio++;
            }
        }
        
        System.out.println("\n=== ESTADÍSTICAS POR TIPO DE ESTUDIANTE ===");
        System.out.println("Estudiantes de Pregrado: " + pregrado);
        System.out.println("Estudiantes de Posgrado: " + posgrado);
        System.out.println("Estudiantes de Intercambio: " + intercambio);
        System.out.println("Total: " + listaEstudiantes.size());
    }
    
    /**
     * NUEVO: Método para aplicar descuentos a todos los estudiantes
     */
    public void mostrarDescuentosMatricula() {
        System.out.println("\n=== DESCUENTOS DE MATRÍCULA ===");
        for (Estudiante est : listaEstudiantes) {
            double descuento = est.calcularDescuentoMatricula();
            System.out.println(est.getNombreCompleto() + " - " + 
                              est.getTipoEstudiante() + ": " + 
                              (descuento * 100) + "% de descuento");
        }
    }
}