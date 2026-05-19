package Componentes;


public class RuedaDeportiva extends Rueda 
{
    public RuedaDeportiva(double ancho, double diametro, double carga, String codigoVelocidad) 
    {
        super(ancho, diametro, carga, codigoVelocidad, TipoRueda.DEPORTIVA);
    }
}
