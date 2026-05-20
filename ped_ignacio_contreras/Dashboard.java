import java.util.List;

/**
 * Clase encargada de la visualización de los datos del sistema.
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
    
    public void mostrarOperariosAlfabeticamente()
    {
        System.out.println("\n--- LISTADO DE OPERARIOS (ALFÄBETICO) ---");
        
        // Pedimos la lista al almacen
        List<Operario> operarios = almacen.getOperariosDisponibles();
        
        // Copiamos la lista para no alterar el original
        List<Operario> listaOrdenada = new java.util.ArrayList<>(operarios);
        
        // Ordenamos la lista
        listaOrdenada.sort((op1, op2) -> op1.getNombre().compareToIgnoreCase(op2.getNombre()));
        
        // Imprimimos el resultado
        for (Operario op : listaOrdenada) 
        {
            System.out.println("-" + op.getNombre() + " | Productividad: " + op.getMontajesRealizados());
        }
    }
    
    public void mostrarOperariosPorProductividad() 
    {
        System.out.println("\n--- LISTADO DE OPERARIOS (POR PRODUCTIVIDAD) ---");
        
        List<Operario> operarios = almacen.getOperariosDisponibles();
        List<Operario> listaOrdenada = new java.util.ArrayList<>(operarios);
        
        // Para ordenar de MAYOR a MENOR productividad, comparamos el op2 con el op1 (al revés)
        listaOrdenada.sort((op1, op2) -> Integer.compare(op2.getMontajesRealizados(), op1.getMontajesRealizados()));
        
        for (Operario op : listaOrdenada) {
            System.out.println("- " + op.getNombre() + " | Productividad: " + op.getMontajesRealizados());
        }
    }
}