import java.util.Date;
import java.util.List;

public class factory_main {

    public static void main(String[] args) {
        
        System.out.println("Iniciando el Sistema de Gestión de Fábrica...");
        
        // 1. Instanciamos nuestro almacén usando la interfaz
        IAlmacen almacen = new AlmacenMemoria();
        
        // Creamos una fecha actual para la fecha de ingreso
        Date fechaHoy = new Date();
        
        // 2. Creamos algunos trabajadores de prueba
        Operario operario1 = new Operario("Ignacio", "García", "11111111A", "Calle Falsa 123", "SS-001", 1500.50, fechaHoy);
        GestorDePlanta gestor1 = new GestorDePlanta("Ana", "López", "22222222B", "Avenida Central 45", "SS-002", 2500.00, fechaHoy);
        MecanicoDeCinta mecanico1 = new MecanicoDeCinta("Carlos", "Ruiz", "33333333C", "Plaza Mayor 1", "SS-003", 1800.00, fechaHoy);
        
        // 3. Los añadimos al almacén
        almacen.registrarTrabajador(operario1);
        almacen.registrarTrabajador(gestor1);
        almacen.registrarTrabajador(mecanico1);
        
        // 4. Recuperamos la lista para comprobar que se han guardado correctamente
        List<Trabajador> plantilla = almacen.getTrabajadores();
        
        System.out.println("\n--- LISTA DE TRABAJADORES EN EL ALMACÉN ---");
        System.out.println("Total de trabajadores registrados: " + plantilla.size());
        
        for (Trabajador t : plantilla) {
            // Imprimimos algunos datos para verificar
            System.out.println("- " + t.getNombre() + " " + t.getApellidos() + " | DNI: " + t.getDni());
        }
        
        // 5. Probamos una lógica específica: ¿Es eficiente el operario?
        System.out.println("\n--- PRUEBA DE LÓGICA DE OPERARIO ---");
        System.out.println("¿Es el operario Ignacio eficiente al contratarlo? " + operario1.isEficiente());
        
        // Simulamos que Ignacio hace 11 montajes
        for (int i = 0; i < 11; i++) {
            operario1.registrarMontaje();
        }
        
        System.out.println("¿Es Ignacio eficiente tras 11 montajes? " + operario1.isEficiente());
    }
}