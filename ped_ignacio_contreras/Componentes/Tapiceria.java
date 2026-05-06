package Componentes;

public abstract class Tapiceria
{
    // instance variables - replace the example below with your own
    private String color;
    private double metrosCuadrados;
    private TipoTapiceria tipo;

    // GETTERS Y SETTERS 
    public Tapiceria(String color, double metrosCuadrados, TipoTapiceria tipo) 
    {
        this.color = color;
        this.metrosCuadrados = metrosCuadrados;
        this.tipo = tipo;
    }
    
    // GETTERS Y SETTERS 
    
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    
    public double getMetrosCuadrados() {return metrosCuadrados;}
    public void setMetrosCuadrados(double metrosCuadrados){this.metrosCuadrados = metrosCuadrados;}
    
}

class TapiceriaTela extends Tapiceria 
{
    public TapiceriaTela(String color, double metrosCuadrados) 
    {   
        super(color, metrosCuadrados, TipoTapiceria.TELA);
    }
}

class TapiceriaCuero extends Tapiceria
{
    public TapiceriaCuero(String color, double metrosCuadrados)
    {
        super(color, metrosCuadrados, TipoTapiceria.CUERO);
    }
}

class TapiceriaAlcantara extends Tapiceria
{
    public TapiceriaAlcantara(String color, double metrosCuadrados)
    {
        super(color, metrosCuadrados, TipoTapiceria.ALCANTARA);
    }
}



enum TipoTapiceria 
{
    TELA, CUERO, ALCANTARA
}