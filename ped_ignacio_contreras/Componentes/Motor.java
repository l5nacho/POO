package Componentes;
/**
 * Write a description of class Motor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public abstract class Motor
{
    private double cilindrada;
    private double potencia;
    private int numeroCilindros;
    private TipoMotor tipo;

    /**
     * Constructor for objects of class Motor
     */
    public Motor(double cilindrada, double potencia, int numeroCilindros, TipoMotor tipo)
    {
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.numeroCilindros = numeroCilindros;
        this.tipo = tipo; 
    }

    // GETTERS y SETTERS
    
    public double getCilindrada() {return cilindrada;}
    public void setCilindrada(double cilindrada) {this.cilindrada = cilindrada;}
    
    public double getPotencia() {return potencia;}
    public void setPotencia(double potencia) {this.potencia = potencia;}
    
    public int getNumeroCilindros() {return numeroCilindros;}
    public void setNumeroCilindros(int numeroCilindros) {this.numeroCilindros = numeroCilindros;}
    
    public TipoMotor getTipo() {return tipo;}
}

class MotorElectrico extends Motor 
{   
    public MotorElectrico(double cilindrada, double potencia, int numeroCilindros) 
    {
        super(0.0, potencia, 0, TipoMotor.ELECTRICO);
    }

}


class MotorGasolina extends Motor 
{
    public MotorGasolina(double cilindrada, double potencia, int numeroCilindros) 
    {
        super(cilindrada, potencia, numeroCilindros, TipoMotor.GASOLINA);
    }
}

class MotorHibrido extends Motor 
{
    public MotorHibrido(double cilindrada, double potencia, int numeroCilindros) 
    {
        super(cilindrada, potencia, numeroCilindros, TipoMotor.HIBRIDO);
    }
}

enum TipoMotor
{
    ELECTRICO, GASOLINA, HIBRIDO
}