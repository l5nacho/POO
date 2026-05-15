import java.util.List;

/**
 * Clase encargada de la visualización de los datos del sistema.
 * Actúa de forma desacoplada: solo lee del almacén y formatea la salida por pantalla.
 */
public class Dashboard 
{
    private IAlmacen almacen;

    // Al crear el dashboard, le "enchufamos" nuestro almacén
    public Dashboard(IAlmacen almacen) 
    {
        this.almacen = almacen;
    }

    /**
     * Muestra una vista general de todo el inventario de la fábrica.
     */
    public void mostrarResumenGeneral() 
    {
        System.out.println("\n=========================================");
        System.out.println("       PANEL DE CONTROL (DASHBOARD)      ");
        System.out.println("=========================================");
        
        System.out.println("\n[1] STOCK DE COMPONENTES:");
        System.out.println("    - Motores disponibles:    " + almacen.contarMotoresDisponibles());
        System.out.println("    - Tapicerías disponibles: " + almacen.contarTapiceriasDisponibles());
        System.out.println("    - Ruedas disponibles:     " + almacen.contarRuedasDisponibles());

        System.out.println("\n[2] PRODUCCIÓN:");
        System.out.println("    - Vehículos terminados/en stock: " + almacen.contarVehiculosEnStock());

        System.out.println("\n[3] RECURSOS HUMANOS:");
        List<Trabajador> plantilla = almacen.getTrabajadores();
        System.out.println("    - Plantilla total: " + plantilla.size() + " empleados.");
        System.out.println("    - Operarios en planta: " + almacen.getOperariosDisponibles().size());
        System.out.println("    - Mecánicos de cinta: " + almacen.getMecanicosDisponibles().size());
        
        System.out.println("=========================================\n");
    }

    /**
     * Muestra el detalle de la plantilla con sus nombres y puestos.
     */
    public void mostrarDetalleTrabajadores() 
    {
        System.out.println("\n--- DETALLE DE PLANTILLA ---");
        List<Trabajador> plantilla = almacen.getTrabajadores();
        
        if (plantilla.isEmpty()) {
            System.out.println("No hay trabajadores registrados en el sistema.");
        } else {
            for (Trabajador t : plantilla) {
                System.out.println(t.getNombre() + " " + t.getApellidos() + " | Puesto: " + t.getPuesto() + " | DNI: " + t.getDni());
            }
        }
        System.out.println("----------------------------\n");
    }
}