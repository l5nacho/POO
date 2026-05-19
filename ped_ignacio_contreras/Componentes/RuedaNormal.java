package Componentes;


public class RuedaNormal extends Rueda 
{
    public RuedaNormal(double ancho, double diametro, double carga, String codigoVelocidad) 
    {
        super(ancho, diametro, carga, codigoVelocidad, TipoRueda.NORMAL);
    }
}