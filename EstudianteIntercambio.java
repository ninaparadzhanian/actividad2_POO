package gestionestudiantes;

/**
 * Clase que representa a un Estudiante de Intercambio
 * Hereda de la clase Estudiante y añade atributos y métodos específicos
 */
public class EstudianteIntercambio extends Estudiante {
    private String paisOrigen;
    private String universidadOrigen;
    private int duracionIntercambio; // en meses
    
    /**
     * Constructor por defecto para EstudianteIntercambio
     */
    public EstudianteIntercambio() {
        super();
        this.paisOrigen = "Sin país";
        this.universidadOrigen = "Sin universidad";
        this.duracionIntercambio = 6; // 6 meses por defecto
    }
    
    /**
     * Constructor parametrizado para EstudianteIntercambio
     */
    public EstudianteIntercambio(String codigo, String nombre, String apellido, 
                                int edad, double promedio, String carrera,
                                String paisOrigen, String universidadOrigen, 
                                int duracionIntercambio) {
        super(codigo, nombre, apellido, edad, promedio, carrera);
        this.paisOrigen = paisOrigen;
        this.universidadOrigen = universidadOrigen;
        this.duracionIntercambio = duracionIntercambio;
    }
    
    // Getters y Setters específicos de Intercambio
    public String getPaisOrigen() { return paisOrigen; }
    public void setPaisOrigen(String paisOrigen) { this.paisOrigen = paisOrigen; }
    
    public String getUniversidadOrigen() { return universidadOrigen; }
    public void setUniversidadOrigen(String universidadOrigen) { this.universidadOrigen = universidadOrigen; }
    
    public int getDuracionIntercambio() { return duracionIntercambio; }
    public void setDuracionIntercambio(int duracionIntercambio) { this.duracionIntercambio = duracionIntercambio; }
    
    /**
     * Sobrescribe el método para calcular descuento
     * Estudiantes de intercambio tienen descuentos especiales
     */
    @Override
    public double calcularDescuentoMatricula() {
        // Estudiantes de intercambio tienen 50% de descuento fijo
        return 0.5;
    }
    
    /**
     * Sobrescribe el método para determinar tipo de estudiante
     */
    @Override
    public String getTipoEstudiante() {
        return "Estudiante de Intercambio";
    }
    
    /**
     * Método específico de intercambio - extender estadía
     */
    public void extenderIntercambio(int mesesAdicionales) {
        duracionIntercambio += mesesAdicionales;
        System.out.println(nombre + " ha extendido su intercambio por " + 
                          mesesAdicionales + " meses. Duración total: " + 
                          duracionIntercambio + " meses");
    }
    
    /**
     * Método específico de intercambio - información del país
     */
    public void mostrarInformacionIntercambio() {
        System.out.println("=== INFORMACIÓN DE INTERCAMBIO ===");
        System.out.println("País de origen: " + paisOrigen);
        System.out.println("Universidad de origen: " + universidadOrigen);
        System.out.println("Duración del intercambio: " + duracionIntercambio + " meses");
        System.out.println("Universidad actual: Universidad Nacional");
    }
    
    /**
     * Sobrescribe el método toString para incluir información específica
     */
    @Override
    public String toString() {
        return super.toString() +
               "\nPaís de Origen: " + paisOrigen +
               "\nUniversidad de Origen: " + universidadOrigen +
               "\nDuración Intercambio: " + duracionIntercambio + " meses";
    }
}