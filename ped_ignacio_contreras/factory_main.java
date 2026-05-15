import java.util.Date;

public class factory_main {

    public static void main(String[] args) {
        
        // 1. Iniciamos el sistema
        IAlmacen almacen = new AlmacenMemoria();
        Dashboard panel = new Dashboard(almacen); // Conectamos el dashboard al almacén
        
        // 2. Metemos algunos datos de prueba
        Date hoy = new Date();
        almacen.registrarTrabajador(new Operario("Ignacio", "García", "11111111A", "Dir", "SS1", 1500, hoy));
        almacen.registrarTrabajador(new MecanicoDeCinta("Carlos", "Ruiz", "33333333C", "Dir", "SS3", 1800, hoy));
        
        // 3. ¡Magia! Imprimimos el panel de control
        panel.mostrarResumenGeneral();
        panel.mostrarDetalleTrabajadores();
    }
}