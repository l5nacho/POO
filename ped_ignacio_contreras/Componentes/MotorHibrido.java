package Componentes;

public class MotorHibrido extends Motor 
{
    public MotorHibrido(double cilindrada, double potencia, int numeroCilindros) 
    {
        super(cilindrada, potencia, numeroCilindros, TipoMotor.HIBRIDO);
    }
}
