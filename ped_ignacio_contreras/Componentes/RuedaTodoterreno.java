package Componentes;

public class RuedaTodoterreno extends Rueda
{
    public RuedaTodoterreno(double ancho, double diametro, double carga, String codigoVelocidad) 
    {
        super(ancho, diametro, carga, codigoVelocidad, TipoRueda.TODOTERRENO);
    }
}