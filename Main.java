package gestionestudiantes;

/**
 * Clase principal que contiene el método main
 * Demuestra la instanciación de objetos y uso de métodos
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE ESTUDIANTES ===\n");
        
        // Creación de instancias de Estudiante usando diferentes constructores
        System.out.println("1. CREACIÓN DE OBJETOS ESTUDIANTE");
        System.out.println("----------------------------------");
        
        // Instanciación usando constructor parametrizado
        Estudiante estudiante1 = new Estudiante("2024001", "Ana", "García", 20, 4.5);
        Estudiante estudiante2 = new Estudiante("2024002", "Carlos", "López", 22, 3.8);
        
        // Instanciación usando constructor por defecto y setters
        Estudiante estudiante3 = new Estudiante();
        estudiante3.setCodigo("2024003");
        estudiante3.setNombre("María");
        estudiante3.setApellido("Rodríguez");
        estudiante3.setEdad(19);
        estudiante3.setPromedio(4.2);
        
        // Mostrar información de los estudiantes creados
        System.out.println("Estudiante 1 creado: " + estudiante1.getNombreCompleto());
        System.out.println("Estudiante 2 creado: " + estudiante2.getNombreCompleto());
        System.out.println("Estudiante 3 creado: " + estudiante3.getNombreCompleto());
        
        // Creación de instancia de Curso
        System.out.println("\n2. CREACIÓN DE CURSO");
        System.out.println("---------------------");
        Curso cursoProgramacion = new Curso("Programación en Java", "PROG-JAVA-101");
        System.out.println("Curso creado: " + cursoProgramacion.getNombreCurso());
        
        // Agregar estudiantes al curso
        System.out.println("\n3. AGREGAR ESTUDIANTES AL CURSO");
        System.out.println("--------------------------------");
        cursoProgramacion.agregarEstudiante(estudiante1);
        cursoProgramacion.agregarEstudiante(estudiante2);
        cursoProgramacion.agregarEstudiante(estudiante3);
        
        // Demostración de métodos de la clase Curso
        System.out.println("\n4. OPERACIONES CON EL CURSO");
        System.out.println("---------------------------");
        
        // Mostrar todos los estudiantes
        cursoProgramacion.mostrarEstudiantes();
        
        // Calcular y mostrar promedio general
        double promedioGeneral = cursoProgramacion.calcularPromedioGeneral();
        System.out.println("\nPromedio general del curso: " + String.format("%.2f", promedioGeneral));
        
        // Contar estudiantes sobresalientes
        int sobresalientes = cursoProgramacion.contarSobresalientes();
        System.out.println("Estudiantes sobresalientes: " + sobresalientes);
        
        // Demostración de métodos de la clase Estudiante
        System.out.println("\n5. OPERACIONES CON ESTUDIANTES");
        System.out.println("------------------------------");
        
        // Usar método getNombreCompleto
        System.out.println("Nombre completo estudiante 1: " + estudiante1.getNombreCompleto());
        
        // Usar método esSobresaliente
        System.out.println("¿Es sobresaliente estudiante 2? " + 
                          (estudiante2.esSobresaliente() ? "Sí" : "No"));
        
        // Usar método cumplirAnios
        System.out.println("\nAntes de cumpleaños - Edad: " + estudiante3.getEdad());
        estudiante3.cumplirAnios();
        System.out.println("Después de cumpleaños - Edad: " + estudiante3.getEdad());
        
        // Búsqueda de estudiante
        System.out.println("\n6. BÚSQUEDA DE ESTUDIANTE");
        System.out.println("--------------------------");
        Estudiante estudianteEncontrado = cursoProgramacion.buscarEstudiante("2024001");
        if (estudianteEncontrado != null) {
            System.out.println("Estudiante encontrado:");
            System.out.println(estudianteEncontrado.toString());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
        
        // Eliminación de estudiante
        System.out.println("\n7. ELIMINACIÓN DE ESTUDIANTE");
        System.out.println("----------------------------");
        cursoProgramacion.eliminarEstudiante("2024002");
        
        // Mostrar lista actualizada
        System.out.println("\nLista actualizada después de eliminar:");
        cursoProgramacion.mostrarEstudiantes();
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}
