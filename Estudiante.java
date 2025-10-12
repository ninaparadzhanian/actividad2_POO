package gestionestudiantes;

/**
 * Clase que representa a un Estudiante en el sistema de gestión
 * Incluye atributos básicos y métodos para manejar la información del estudiante
 */
public class Estudiante {
    // Atributos de la clase
    private String codigo;
    private String nombre;
    private String apellido;
    private int edad;
    private double promedio;
    
    /**
     * Constructor por defecto, inicializa un estudiante con valores predeterminados
     */
    public Estudiante() {
        this.codigo = "SIN-CODIGO";
        this.nombre = "Sin nombre";
        this.apellido = "Sin apellido";
        this.edad = 0;
        this.promedio = 0.0;
    }
    
    /**
     * Constructor parametrizado - permite crear un estudiante con datos específicos
     * @param codigo Identificador único del estudiante
     * @param nombre Nombre del estudiante
     * @param apellido Apellido del estudiante
     * @param edad Edad del estudiante
     * @param promedio Promedio académico
     */
    public Estudiante(String codigo, String nombre, String apellido, int edad, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.promedio = promedio;
    }
    
    // Métodos Getters y Setters
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public double getPromedio() {
        return promedio;
    }
    
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    /**
     * Método para obtener el nombre completo del estudiante
     * @return Cadena con nombre y apellido concatenados
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    /**
     * Método para determinar si el estudiante tiene un promedio sobresaliente
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
     * Método toString - sobreescribe el método para mostrar información del estudiante
     * @return Cadena con la información formateada del estudiante
     */
    @Override
    public String toString() {
        return "Código: " + codigo + 
               "\nNombre: " + getNombreCompleto() + 
               "\nEdad: " + edad + 
               "\nPromedio: " + promedio + 
               "\nSobresaliente: " + (esSobresaliente() ? "Sí" : "No");
    }
}
