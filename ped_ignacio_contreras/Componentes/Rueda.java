package Componentes;

public abstract class Rueda
{
    // instance variables - replace the example below with your own
    private double ancho;
    private double diametro;
    private double carga;
    private String codigoVelocidad; // Es tipo String porque voy a usar letras para representar la velocidad maxima permitida (como en la vida real)
    private TipoRueda tipo;

    /**
     * Constructor for objects of class Rueda
     */
    public Rueda(double ancho, double diametro, double carga, String codigoVelocidad, TipoRueda tipo)
    {
        this.ancho = ancho;
        this.diametro = diametro;
        this.carga = carga;
        this.codigoVelocidad = codigoVelocidad;
        this.tipo = tipo;
    }

    // GETTERS Y SETTERS
    public double getAncho() {return ancho;}
    public void setAncho(int ancho) {this.ancho = ancho;}
    
    public double getDiametro() {return diametro;}
    public void setDiametro(double diametro) {this.diametro = diametro;}
    
    public double getCarga() {return carga;}
    public void setCarga(double carga) {this.carga = carga;}
    
    public String getCodigoVelocidad() {return codigoVelocidad;}
    public void setCodigoVelocidad(String codigoVelocidad) {this.codigoVelocidad = codigoVelocidad;}
    
    
}
class RuedaNormal extends Rueda 
{
    public RuedaNormal(double ancho, double diametro, double carga, String codigoVelocidad) 
    {
        super(ancho, diametro, carga, codigoVelocidad, TipoRueda.NORMAL);
    }
}

class RuedaDeportiva extends Rueda 
{
    public RuedaDeportiva(double ancho, double diametro, double carga, String codigoVelocidad) 
    {
        super(ancho, diametro, carga, codigoVelocidad, TipoRueda.DEPORTIVA);
    }
}

class RuedaTodoterreno extends Rueda
{
    public RuedaTodoterreno(double ancho, double diametro, double carga, String codigoVelocidad) 
    {
        super(ancho, diametro, carga, codigoVelocidad, TipoRueda.TODOTERRENO);
    }
}

enum TipoRueda 
{
    NORMAL, DEPORTIVA, TODOTERRENO
}