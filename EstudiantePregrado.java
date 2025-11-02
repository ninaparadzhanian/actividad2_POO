package gestionestudiantes;

/**
 * Clase que representa a un Estudiante de Pregrado
 * Hereda de la clase Estudiante y añade atributos y métodos específicos
 */
public class EstudiantePregrado extends Estudiante {
    private int semestre;
    private boolean tieneBeca;
    
    /**
     * Constructor por defecto para EstudiantePregrado
     * Llama al constructor de la clase base
     */
    public EstudiantePregrado() {
        super(); // Llama al constructor de la clase base
        this.semestre = 1;
        this.tieneBeca = false;
    }
    
    /**
     * Constructor parametrizado para EstudiantePregrado
     * @param codigo Código del estudiante
     * @param nombre Nombre del estudiante
     * @param apellido Apellido del estudiante
     * @param edad Edad del estudiante
     * @param promedio Promedio académico
     * @param carrera Carrera que estudia
     * @param semestre Semestre actual
     * @param tieneBeca Indica si tiene beca
     */
    public EstudiantePregrado(String codigo, String nombre, String apellido, 
                             int edad, double promedio, String carrera,
                             int semestre, boolean tieneBeca) {
        // Llama al constructor de la clase base
        super(codigo, nombre, apellido, edad, promedio, carrera);
        this.semestre = semestre;
        this.tieneBeca = tieneBeca;
    }
    
    // Getters y Setters específicos de Pregrado
    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
    
    public boolean isTieneBeca() { return tieneBeca; }
    public void setTieneBeca(boolean tieneBeca) { this.tieneBeca = tieneBeca; }
    
    /**
     * Sobrescribe el método para calcular descuento
     * Los estudiantes de pregrado con beca tienen descuento adicional
     */
    @Override
    public double calcularDescuentoMatricula() {
        double descuentoBase = super.calcularDescuentoMatricula(); // Llama al método de la clase base
        
        if (tieneBeca) {
            return descuentoBase + 0.1; // 10% adicional por beca
        }
        return descuentoBase;
    }
    
    /**
     * Sobrescribe el método para determinar tipo de estudiante
     */
    @Override
    public String getTipoEstudiante() {
        return "Estudiante de Pregrado";
    }
    
    /**
     * Método específico de pregrado - avanza de semestre
     */
    public void avanzarSemestre() {
        if (semestre < 10) { // Asumiendo máximo 10 semestres
            semestre++;
            System.out.println(nombre + " ha avanzado al semestre " + semestre);
        } else {
            System.out.println(nombre + " ya ha completado todos los semestres");
        }
    }
    
    /**
     * Sobrescribe el método toString para incluir información específica
     */
    @Override
    public String toString() {
        return super.toString() + // Llama al toString de la clase base
               "\nSemestre: " + semestre +
               "\nBeca: " + (tieneBeca ? "Sí" : "No");
    }
}