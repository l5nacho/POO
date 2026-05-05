
/**
 * Clase abstracta que representa a un vehiculo
 * 
 * @author Ignacio Contreras
 * @version v1 20260427
 */

// FALTA IMPLEMENTAR EL PAQUETE COMPONENTES
import Componentes.Motor;
import Componentes.Tapiceria;
import Componentes.Rueda;

public abstract class Vehiculo
{
    // Las características que se guardan de los vehículos son las siguientes: color, número de plazas, tara del vehículo y peso máximo autorizado.
    // Atributos comunes
    private String color;
    private int numeroPlazas;
    private double tara;
    private double pesoMaxAutorizado;
        
    // Estado en la cadena de montaje
    private EstadoVehiculo estado;
        
    // Componentes del vehiculo
    private Motor motor;
    private Tapiceria tapiceria;
    private Rueda rueda;

    /**
     * Constructor for objects of class Vehiculo
     * 
     * @param Color                 Color del vehiculo
     * @param numeroPlazas          Numero de plazas del vehiculo
     * @param tara                  Tara del vehiculo en kg
     * @param pesoMaxAutorizado     Peso máximo autorizado del vehiculo en kg
     */
    public Vehiculo(String color, int numeroPlazas, double tara, double pesoMaxAutorizado)
    {   
        this.color = color;
        this.numeroPlazas = numeroPlazas;
        this.tara = tara;
        this.pesoMaxAutorizado = pesoMaxAutorizado;
        
        // Estado inicial al entrar en la cadena
        this.estado = EstadoVehiculo.CHASIS;

    }

    // Getters y Setters
    
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    
    public int getNumeroPlazas() {return numeroPlazas;}
    public void setNumeroPlazas(int numeroPlazas) {this.numeroPlazas = numeroPlazas;}
    
    public double getTara() {return tara;}
    public void setTara(double tara) {this.tara = tara;}
    
    public double getPesoMaximoAutorizado(){return pesoMaxAutorizado;}
    public void setPesoMaximoAutorizado(double pesoMaxAutorizado) {this.pesoMaxAutorizado = pesoMaxAutorizado;}
        
    
    /**
     * Metodo para avanzar el estado del vehiculo al siguiente paso de la cadena de montaje
     */
    
    public void avanzarEstado() 
    {
        switch (this.estado) {
            case CHASIS:
                this.estado = EstadoVehiculo.MOTOR;
                break;
            
            case MOTOR:
                this.estado = EstadoVehiculo.TAPICERIA;
                break;
                
            case TAPICERIA:
                this.estado = EstadoVehiculo.RUEDAS;
                break;
                
            case RUEDAS:
                this.estado = EstadoVehiculo.TERMINADO;
                break;
                
            case TERMINADO:
                System.out.println("El vehiculo ya está terminado");
                break;
        }
    
    }
}

class BiplazaDeportivo extends Vehiculo 
{
    public BiplazaDeportivo(String color, int numeroPlazas, double tara, double pesoMaxAutorizado)
    {
        super(color, 2, tara, pesoMaxAutorizado);
    }
}

class Turismo extends Vehiculo 
{
    public Turismo(String color, int numeroPlazas, double tara, double pesoMaxAutorizado) 
    {
        super(color, numeroPlazas, tara, pesoMaxAutorizado);
    }
}

class Furgoneta extends Vehiculo 
{
    public Furgoneta(String color, int numeroPlazas, double tara, double pesoMaxAutorizado)
    {
        super(color, numeroPlazas, tara, pesoMaxAutorizado);
    }
}