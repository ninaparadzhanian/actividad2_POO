package gestionestudiantes;

/**
 * Clase base que representa a un Estudiante en el sistema de gestión
 * Esta clase será extendida por diferentes tipos de estudiantes
 */
public class Estudiante {
    // Atributos protegidos para permitir acceso a las subclases
    protected String codigo;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected double promedio;
    protected String carrera;
    
    /**
     * Constructor por defecto de la clase base
     */
    public Estudiante() {
        this.codigo = "SIN-CODIGO";
        this.nombre = "Sin nombre";
        this.apellido = "Sin apellido";
        this.edad = 0;
        this.promedio = 0.0;
        this.carrera = "Sin carrera";
    }
    
    /**
     * Constructor parametrizado de la clase base
     */
    public Estudiante(String codigo, String nombre, String apellido, 
                     int edad, double promedio, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.promedio = promedio;
        this.carrera = carrera;
    }
    
    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
    
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    
    /**
     * Método para obtener el nombre completo del estudiante
     * @return Cadena con nombre y apellido concatenados
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    /**
     * Método para determinar si el estudiante tiene un promedio sobresaliente
     * Este método puede ser sobrescrito por las subclases
     * @return true si el promedio es mayor o igual a 4.0
     */
    public boolean esSobresaliente() {
        return promedio >= 4.0;
    }
    
    /**
     * Método para incrementar la edad del estudiante
     * Simula el cumplimiento de años
     */
    public void cumplirAnios() {
        this.edad++;
        System.out.println("¡Feliz cumpleaños " + nombre + "! Ahora tienes " + edad + " años.");
    }
    
    /**
     * Método que calcula el descuento en matrícula
     * Puede ser sobrescrito por subclases para diferentes cálculos
     * @return porcentaje de descuento
     */
    public double calcularDescuentoMatricula() {
        if (promedio >= 4.5) {
            return 0.3; // 30% de descuento
        } else if (promedio >= 4.0) {
            return 0.2; // 20% de descuento
        } else if (promedio >= 3.5) {
            return 0.1; // 10% de descuento
        }
        return 0.0; // Sin descuento
    }
    
    /**
     * Método que devuelve el tipo de estudiante
     * Será sobrescrito por cada subclase
     * @return tipo de estudiante
     */
    public String getTipoEstudiante() {
        return "Estudiante Regular";
    }
    
    /**
     * Método toString - muestra información del estudiante
     * Puede ser extendido por las subclases
     */
    @Override
    public String toString() {
        return "Tipo: " + getTipoEstudiante() +
               "\nCódigo: " + codigo + 
               "\nNombre: " + getNombreCompleto() + 
               "\nEdad: " + edad + 
               "\nCarrera: " + carrera +
               "\nPromedio: " + promedio + 
               "\nSobresaliente: " + (esSobresaliente() ? "Sí" : "No") +
               "\nDescuento matrícula: " + (calcularDescuentoMatricula() * 100) + "%";
    }
}
