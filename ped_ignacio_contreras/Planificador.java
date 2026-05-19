import java.util.List;

import Componentes.Motor;
import Componentes.Tapiceria;
import Componentes.Rueda;

public class Planificador
{
    private IAlmacen almacen;
    
    public Planificador(IAlmacen almacen)
    {
        this.almacen = almacen;
    }
    
    // El parametro modo marca el tipo de simulacion: 1: Simple, 2: complejo, 3: Muy compleja
    public void fabricarVehiculo(Vehiculo vehiculo, int modo)
    {
        System.out.println("\n>>> INICIANDO CADENA DE MONTAJE (MODO " + modo + ") <<<");
        
        List<Operario> operarios = almacen.getOperariosDisponibles();
        
        if (operarios.isEmpty()) 
        {
            System.out.println("¡ALERTA! No hay operarios disponibles");
            return;
        }
        
        Operario currante = operarios.get(0);
        System.out.println("Operario asignado a la cadena: " + currante.getNombre() + " (Eficiente: " + currante.isEficiente() + ")");
        
        boolean roturaDeStock = false;
        
        while (vehiculo.getEstado() != EstadoVehiculo.TERMINADO && !roturaDeStock)
        {
            System.out.println("\nProcesando fase " + vehiculo.getEstado());
            
            // 1. LLAMAMOS AL RELOJ PARA QUE PASE EL TIEMPO
            simularTrabajo(currante);
            
            // 2. HACEMOS LA INSTALACIÓN
            switch (vehiculo.getEstado()) 
            {
                case CHASIS:
                    System.out.println("   -> Chasis revisado. Avanzando a la siguiente estación...");
                    break;
                    
                case MOTOR:
                    Motor m = almacen.extraerMotor();
                    if (m != null) {
                        vehiculo.setMotor(m);
                        System.out.println("   -> Motor instalado con exito");
                    } else {
                        System.out.println("   [ERROR] No quedan motores en el almacén");
                        roturaDeStock = true;
                    }
                    break;
                
                case TAPICERIA:
                    Tapiceria t = almacen.extraerTapiceria();
                    if (t!= null) {
                        vehiculo.setTapiceria(t);
                        System.out.println("   -> Tapiceria instalada con exito");
                    } else {
                        System.out.println("   [ERROR] No quedan tapicerias en el almacén");
                        roturaDeStock = true;
                    }
                    break;
                
                case RUEDAS:
                    Rueda r = almacen.extraerRuedas();
                    if (r != null) {
                        vehiculo.setRueda(r);
                        System.out.println("   -> Juego de ruedas instalado con éxito.");
                    } else {
                        System.out.println("   [ERROR] ¡No quedan ruedas en el almacén!");
                        roturaDeStock = true;
                    }
                    break;
            }
        
            if (roturaDeStock) 
            { 
                System.out.println("   [ERROR] ¡No queda stock de la pieza necesaria!");
            } else {
                vehiculo.avanzarEstado();
                currante.registrarMontaje(); // Operario gana un montaje para su experiencia
            }
        }
        
        if (vehiculo.getEstado() == EstadoVehiculo.TERMINADO) {
            almacen.almacenarVehiculo(vehiculo);
            System.out.println(">>> VEHICULO COMPLETADO Y ALMACENADO <<<");
        }
    }
    
    private int simularTrabajo(Operario operario) 
    {
        // Si el operador es eficiente tarda 1 segundo
        int segundos = 1;
        
        if (!operario.isEficiente())
        {
            // si no es eficiente, tarda entre 2 y 5 segundos
            segundos = (int) (Math.random() * 4) + 2;
        }
        
        System.out.println("   [RELOJ] El operario " + operario.getNombre() + " necesita " + segundos + " segundos para esta fase.");
        
        for (int i = 1; i <= segundos; i++) 
        {
            try {
                Thread.sleep(1000); // Pausamos el programa 1 segundo
                System.out.println("  ... tic tac (" + i + "/" + segundos + ")");
                System.out.flush(); // Forzamos a que se imprima al instante
            } catch (InterruptedException e) {
                System.out.println("Error en el reloj de la simulación");
            }
        }
        return segundos;
    }
}