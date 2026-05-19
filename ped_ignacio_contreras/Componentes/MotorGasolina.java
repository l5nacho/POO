package Componentes;

public class MotorGasolina extends Motor 
{
    public MotorGasolina(double cilindrada, double potencia, int numeroCilindros) 
    {
        super(cilindrada, potencia, numeroCilindros, TipoMotor.GASOLINA);
    }
}

