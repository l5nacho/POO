package Componentes;

public class MotorElectrico extends Motor 
{   
    public MotorElectrico(double potencia) 
    {
        super(0.0, potencia, 0, TipoMotor.ELECTRICO);
    }

}
