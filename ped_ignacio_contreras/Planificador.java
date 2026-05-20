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
    
        boolean roturaDeStock = false;
        int turno = 0;
        
        while (vehiculo.getEstado() != EstadoVehiculo.TERMINADO && !roturaDeStock)
        {
            System.out.println("\nProcesando fase " + vehiculo.getEstado());
            
            Operario currante = operarios.get(turno % operarios.size());
            System.out.println("   -> Trabajador en esta estación: " + currante.getNombre() + " (Eficiente: " + currante.isEficiente() + ")");
            turno++;
            
            // --- NUEVO: MODO 3 (APAGONES CRÍTICOS) ---
            if (modo == 3) 
            {
                // 10% de probabilidad de que se vaya la luz en toda la fábrica
                if (Math.random() < 0.10) 
                {
                    System.out.println("   [¡BLACKOUT!] Apagón general. Sistemas de la fábrica caídos.");
                    
                    // Suponiendo que has creado este método en tu almacén:
                    List<AdministradorDelSistema> admins = almacen.getAdministradoresDisponibles();
                    
                    if (!admins.isEmpty()) {
                        AdministradorDelSistema admin = admins.get(0);
                        System.out.println("   -> Llamando al Administrador: " + admin.getNombre());
                        simularReinicioSistema(admin);
                        System.out.println("   [INFO] Servidores online. Energía restaurada.");
                    } else {
                        System.out.println("   [FATAL] No hay administradores contratados. Fin de la simulación.");
                        break;
                    }
                }
            }
            // --- FIN NUEVO MODO 3 ---
            
            if (modo >= 2) 
            {
                // 20% de posibilidades de que la maquina se atasque
                if (Math.random() < 0.20)
                {
                    System.out.println("  [ALERTA] La cinta se ha atascado, es necesario llamar a un mecanico");
                    
                    List<MecanicoDeCinta> mecanicos = almacen.getMecanicosDisponibles();
                    
                    if (!mecanicos.isEmpty()) {
                        MecanicoDeCinta mecanico = mecanicos.get(0);
                        System.out.println("   -> Llamando al mecanico "+ mecanico.getNombre());
                        simularReparacion(mecanico);
                        mecanico.registrarReparacion();
                        System.out.println("  [INFORMACION] Cinta operativa de nuevo, volvemos a producir");
                    } else {
                        System.out.println("  [ERROR] No hay mecanicos en la fabrica. Sal a contratar alguno");
                        break;
                    }
                }
            }
            
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
    
    private int simularReparacion(MecanicoDeCinta mecanico) 
    {
        int segundos = 1;
        
        if (!mecanico.isEfectivo()) 
        {
            segundos = (int) (Math.random() * 4) + 2;
        }
        
        System.out.println("   [RELOJ-MANTENIMIENTO] El mecanico " + mecanico.getNombre() + " necesita " + segundos + " segundos para reparar la cinta.");
        
        for (int i = 1; i <= segundos; i++) 
        {
            try {
                Thread.sleep(1000);
                System.out.println("  ... tris tras (" + i + "/" + segundos + ") [Reparando]");
                System.out.flush();
            } catch (InterruptedException e) {
                System.out.println("Error en el reloj");
            }
        }
        return segundos;
    }
    
    private int simularReinicioSistema(AdministradorDelSistema admin) 
    {
        int segundos = 3;
        System.out.println("   [RELOJ-SISTEMA] El administrador" + admin.getNombre() + " esta reiniciando el sistema (" + segundos + " seg)");
        
        for (int i= 1; i <= segundos; i++)
        {
            try {
                Thread.sleep(1000);
                System.out.println("   .... reiniciando (" + i + "/" + segundos + ") [restaurando sistemas]");
                System.out.flush();
            } catch (InterruptedException e) {
                System.out.println("Error en el reloj");
            }
        }
        return segundos;
        }
}