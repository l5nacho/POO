import java.util.Date;
import Componentes.*; // Importamos todas las piezas de golpe

public class factory_main {

    public static void main(String[] args) {
        
        IAlmacen almacen = new AlmacenMemoria();
        Dashboard panel = new Dashboard(almacen);
        Planificador planificador = new Planificador(almacen); 
        
        Date hoy = new Date();
        
        System.out.println("--- 1. CONTRATACIÓN MASIVA ---");
        // Los metemos desordenados alfabéticamente a propósito para probar luego los filtros
        almacen.registrarTrabajador(new Operario("Zacarías", "Martínez", "111", "Dir1", "SS1", 1500, hoy));
        almacen.registrarTrabajador(new Operario("Ana", "Gómez", "222", "Dir2", "SS2", 1500, hoy));
        almacen.registrarTrabajador(new Operario("Carlos", "López", "333", "Dir3", "SS3", 1550, hoy));
        almacen.registrarTrabajador(new MecanicoDeCinta("Beatriz", "Ruiz", "444", "Dir4", "SS4", 1800, hoy));
        almacen.registrarTrabajador(new AdministradorDelSistema("Joe", "Pesci", "555", "Dir5", "SS5", 2500, hoy));
        
        System.out.println("--- 2. RECEPCIÓN DE MERCANCÍAS ---");
        // Compramos 3 de cada para que haya stock de sobra
        almacen.almacenarMotor(new MotorElectrico(120.0));
        almacen.almacenarMotor(new MotorElectrico(150.0));
        almacen.almacenarMotor(new MotorElectrico(200.0));
        
        almacen.almacenarTapiceria(new TapiceriaCuero("Beige", 25.5));
        almacen.almacenarTapiceria(new TapiceriaCuero("Negro", 30.0));
        almacen.almacenarTapiceria(new TapiceriaCuero("Blanco", 28.5));
        
        almacen.almacenarRueda(new RuedaDeportiva(17.0, 45.0, 20.5, "R17-Normal")); 
        almacen.almacenarRueda(new RuedaDeportiva(18.0, 40.0, 22.5, "R18-Sport")); 
        almacen.almacenarRueda(new RuedaDeportiva(19.0, 35.0, 25.0, "R19-Premium")); 
        
        System.out.println("\n--- 3. INICIO DE PRODUCCIÓN EN CADENA ---");
        Vehiculo coche1 = new BiplazaDeportivo("Rojo", 1200.0, 1500.0);
        Vehiculo coche2 = new Turismo("Azul", 5, 1400.0, 2000.0);
        Vehiculo coche3 = new Furgoneta("Blanco", 3, 1800.0, 3500.0);
        
        // El planificador usará a los operarios disponibles y gastará el stock
        planificador.fabricarVehiculo(coche1, 2);
        planificador.fabricarVehiculo(coche2, 2);
        planificador.fabricarVehiculo(coche3, 2);
        
        System.out.println("\n--- 4. ESTADO FINAL DEL SISTEMA ---");
        panel.mostrarResumenGeneral();
        panel.mostrarOperariosAlfabeticamente();
        panel.mostrarOperariosPorProductividad();
    }
}