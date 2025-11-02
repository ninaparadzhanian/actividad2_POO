package gestionestudiantes;

/**
 * Clase principal que demuestra el uso de la herencia
 * Instancia objetos de diferentes subclases y prueba sus métodos
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE ESTUDIANTES CON HERENCIA ===\n");
        
        // ====================================================================
        // DEMOSTRACIÓN DE HERENCIA: CREACIÓN DE OBJETOS DE DIFERENTES SUBCLASES
        // ====================================================================
        
        System.out.println("1. CREACIÓN DE ESTUDIANTES DE DIFERENTES TIPOS");
        System.out.println("===============================================");
        
        // Crear estudiante de pregrado
        EstudiantePregrado estPregrado1 = new EstudiantePregrado(
            "2024001", "Ana", "García", 20, 4.5, "Ingeniería de Sistemas", 
            4, true
        );
        
        EstudiantePregrado estPregrado2 = new EstudiantePregrado(
            "2024002", "Carlos", "López", 22, 3.8, "Administración", 
            6, false
        );
        
        // Crear estudiante de posgrado
        EstudiantePosgrado estPosgrado1 = new EstudiantePosgrado(
            "PG2024001", "María", "Rodríguez", 25, 4.6, "Maestría en IA",
            "Maestría", "Inteligencia Artificial", true
        );
        
        EstudiantePosgrado estPosgrado2 = new EstudiantePosgrado(
            "PG2024002", "Roberto", "Silva", 28, 4.8, "Doctorado en Ciencias",
            "Doctorado", "Bioinformática", true
        );
        
        // Crear estudiante de intercambio
        EstudianteIntercambio estIntercambio1 = new EstudianteIntercambio(
            "INT2024001", "John", "Smith", 21, 4.2, "Ingeniería Civil",
            "Estados Unidos", "MIT", 12
        );
        
        EstudianteIntercambio estIntercambio2 = new EstudianteIntercambio(
            "INT2024002", "Sophie", "Martin", 23, 4.4, "Medicina",
            "Francia", "Universidad de París", 6
        );
        
        System.out.println("✓ Se crearon 6 estudiantes de diferentes tipos");
        
        // ====================================================================
        // DEMOSTRACIÓN DE POLIMORFISMO: USO DE OBJETOS A TRAVÉS DE LA CLASE BASE
        // ====================================================================
        
        System.out.println("\n2. POLIMORFISMO: AGREGAR ESTUDIANTES AL CURSO");
        System.out.println("==============================================");
        
        Curso cursoProgramacion = new Curso("Programación Avanzada", "PROG401");
        
        // Polimorfismo: podemos agregar cualquier subclase de Estudiante
        cursoProgramacion.agregarEstudiante(estPregrado1);
        cursoProgramacion.agregarEstudiante(estPregrado2);
        cursoProgramacion.agregarEstudiante(estPosgrado1);
        cursoProgramacion.agregarEstudiante(estPosgrado2);
        cursoProgramacion.agregarEstudiante(estIntercambio1);
        cursoProgramacion.agregarEstudiante(estIntercambio2);
        
        // ====================================================================
        // DEMOSTRACIÓN DE MÉTODOS SOBRESCRITOS Y ESPECÍFICOS
        // ====================================================================
        
        System.out.println("\n3. MÉTODOS SOBRESCRITOS Y ESPECÍFICOS");
        System.out.println("======================================");
        
        // Mostrar información de todos los estudiantes
        cursoProgramacion.mostrarEstudiantes();
        
        // Estadísticas por tipo de estudiante
        cursoProgramacion.mostrarEstadisticasPorTipo();
        
        // Descuentos de matrícula (método sobrescrito)
        cursoProgramacion.mostrarDescuentosMatricula();
        
        // ====================================================================
        // DEMOSTRACIÓN DE MÉTODOS ESPECÍFICOS DE CADA SUBCLASE
        // ====================================================================
        
        System.out.println("\n4. MÉTODOS ESPECÍFICOS DE CADA SUBCLASE");
        System.out.println("========================================");
        
        // Método específico de EstudiantePregrado
        System.out.println("\n--- Métodos de Pregrado ---");
        estPregrado1.avanzarSemestre();
        
        // Método específico de EstudiantePosgrado
        System.out.println("\n--- Métodos de Posgrado ---");
        estPosgrado1.publicarInvestigacion("Nuevos algoritmos de machine learning");
        
        // Método específico de EstudianteIntercambio
        System.out.println("\n--- Métodos de Intercambio ---");
        estIntercambio1.mostrarInformacionIntercambio();
        estIntercambio1.extenderIntercambio(3);
        
        // ====================================================================
        // DEMOSTRACIÓN DE SOBRESCRITURA DE MÉTODOS
        // ====================================================================
        
        System.out.println("\n5. COMPARACIÓN DE MÉTODOS SOBRESCRITOS");
        System.out.println("=======================================");
        
        // esSobresaliente() sobrescrito en EstudiantePosgrado
        System.out.println("\n¿Es sobresaliente? (criterios diferentes):");
        System.out.println(estPregrado1.getNombreCompleto() + " (Pregrado): " + 
                          estPregrado1.esSobresaliente() + " (criterio: ≥4.0)");
        System.out.println(estPosgrado1.getNombreCompleto() + " (Posgrado): " + 
                          estPosgrado1.esSobresaliente() + " (criterio: ≥4.3)");
        
        // ====================================================================
        // USO DE INSTANCEOF PARA IDENTIFICAR TIPOS ESPECÍFICOS
        // ====================================================================
        
        System.out.println("\n6. IDENTIFICACIÓN DE TIPOS CON INSTANCEOF");
        System.out.println("==========================================");
        
        for (Estudiante est : cursoProgramacion.getListaEstudiantes()) {
            if (est instanceof EstudiantePregrado) {
                EstudiantePregrado pregrado = (EstudiantePregrado) est;
                System.out.println(pregrado.getNombreCompleto() + " está en semestre " + 
                                  pregrado.getSemestre());
            } else if (est instanceof EstudiantePosgrado) {
                EstudiantePosgrado posgrado = (EstudiantePosgrado) est;
                System.out.println(posgrado.getNombreCompleto() + " investiga en: " + 
                                  posgrado.getLineaInvestigacion());
            } else if (est instanceof EstudianteIntercambio) {
                EstudianteIntercambio intercambio = (EstudianteIntercambio) est;
                System.out.println(intercambio.getNombreCompleto() + " viene de: " + 
                                  intercambio.getPaisOrigen());
            }
        }
        
        // ====================================================================
        // ESTADÍSTICAS FINALES
        // ====================================================================
        
        System.out.println("\n7. ESTADÍSTICAS FINALES DEL CURSO");
        System.out.println("==================================");
        
        System.out.println("Promedio general del curso: " + 
                          String.format("%.2f", cursoProgramacion.calcularPromedioGeneral()));
        System.out.println("Estudiantes sobresalientes: " + 
                          cursoProgramacion.contarSobresalientes());
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN DE HERENCIA ===");
    }
}