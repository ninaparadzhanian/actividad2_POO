package gestionestudiantes;

/**
 * Clase que representa a un Estudiante de Posgrado
 * Hereda de la clase Estudiante y añade atributos y métodos específicos
 */
public class EstudiantePosgrado extends Estudiante {
    private String tipoPosgrado; // "Maestría" o "Doctorado"
    private String lineaInvestigacion;
    private boolean tieneBecaInvestigacion;
    
    /**
     * Constructor por defecto para EstudiantePosgrado
     */
    public EstudiantePosgrado() {
        super();
        this.tipoPosgrado = "Maestría";
        this.lineaInvestigacion = "Sin línea de investigación";
        this.tieneBecaInvestigacion = false;
    }
    
    /**
     * Constructor parametrizado para EstudiantePosgrado
     */
    public EstudiantePosgrado(String codigo, String nombre, String apellido, 
                             int edad, double promedio, String carrera,
                             String tipoPosgrado, String lineaInvestigacion, 
                             boolean tieneBecaInvestigacion) {
        super(codigo, nombre, apellido, edad, promedio, carrera);
        this.tipoPosgrado = tipoPosgrado;
        this.lineaInvestigacion = lineaInvestigacion;
        this.tieneBecaInvestigacion = tieneBecaInvestigacion;
    }
    
    // Getters y Setters específicos de Posgrado
    public String getTipoPosgrado() { return tipoPosgrado; }
    public void setTipoPosgrado(String tipoPosgrado) { this.tipoPosgrado = tipoPosgrado; }
    
    public String getLineaInvestigacion() { return lineaInvestigacion; }
    public void setLineaInvestigacion(String lineaInvestigacion) { this.lineaInvestigacion = lineaInvestigacion; }
    
    public boolean isTieneBecaInvestigacion() { return tieneBecaInvestigacion; }
    public void setTieneBecaInvestigacion(boolean tieneBecaInvestigacion) { 
        this.tieneBecaInvestigacion = tieneBecaInvestigacion; 
    }
    
    /**
     * Sobrescribe el método para calcular descuento
     * Los estudiantes de posgrado tienen diferentes criterios
     */
    @Override
    public double calcularDescuentoMatricula() {
        double descuento = 0.0;
        
        if (tipoPosgrado.equals("Doctorado")) {
            descuento += 0.4; // 40% base para doctorado
        } else if (tipoPosgrado.equals("Maestría")) {
            descuento += 0.2; // 20% base para maestría
        }
        
        if (tieneBecaInvestigacion) {
            descuento += 0.3; // 30% adicional por beca de investigación
        }
        
        // Asegurar que el descuento no exceda el 80%
        return Math.min(descuento, 0.8);
    }
    
    /**
     * Sobrescribe el método para determinar tipo de estudiante
     */
    @Override
    public String getTipoEstudiante() {
        return "Estudiante de " + tipoPosgrado;
    }
    
    /**
     * Sobrescribe el criterio de sobresaliente para posgrado
     */
    @Override
    public boolean esSobresaliente() {
        return promedio >= 4.3; // Criterio más estricto para posgrado
    }
    
    /**
     * Método específico de posgrado - publicar investigación
     */
    public void publicarInvestigacion(String titulo) {
        System.out.println(nombre + " ha publicado: '" + titulo + "'");
        System.out.println("Línea de investigación: " + lineaInvestigacion);
    }
    
    /**
     * Sobrescribe el método toString para incluir información específica
     */
    @Override
    public String toString() {
        return super.toString() +
               "\nTipo de Posgrado: " + tipoPosgrado +
               "\nLínea de Investigación: " + lineaInvestigacion +
               "\nBeca de Investigación: " + (tieneBecaInvestigacion ? "Sí" : "No");
    }
}