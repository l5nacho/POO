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

