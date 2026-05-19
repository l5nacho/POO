package Componentes;

public abstract class Motor
{
    private double cilindrada;
    private double potencia;
    private int numeroCilindros;
    private TipoMotor tipo;

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
