import java.util.ArrayList;
import java.util.List;

import Componentes.Motor;
import Componentes.Tapiceria;
import Componentes.Rueda;

public class AlmacenMemoria implements IAlmacen
{
    // instance variables - replace the example below with your own
    private List<Trabajador> plantillaTrabajadores;
    private List<Motor> stockMotores;
    private List<Tapiceria> stockTapicerias;
    private List<Rueda> stockRuedas;
    private List<Vehiculo> stockVehiculos;

    /**
     * Constructor for objects of class AlmacenMemoria
     */
    public AlmacenMemoria()
    {
        this.plantillaTrabajadores = new ArrayList<>();
        this.stockMotores = new ArrayList<>();
        this.stockTapicerias = new ArrayList<>();
        this.stockRuedas = new ArrayList<>();
        this.stockVehiculos = new ArrayList<>();
    }
    
    @Override
    public void registrarTrabajador(Trabajador t) 
    {
        this.plantillaTrabajadores.add(t);
    }
    
    @Override
    public List<Trabajador> getTrabajadores() 
    {
        return this.plantillaTrabajadores;
    }
    
    @Override
    public void almacenarMotor(Motor m) 
    {
        this.stockMotores.add(m);
    }
    
    @Override
    public void almacenarTapiceria(Tapiceria t) 
    {
        this.stockTapicerias.add(t);
    }
    
    @Override
    public void almacenarRueda(Rueda r) 
    {
        this.stockRuedas.add(r);
    }
    
    @Override
    public void almacenarVehiculo(Vehiculo v) 
    {
        this.stockVehiculos.add(v);
    }
    
    @Override
    public List<Vehiculo> getVehiculosEnStock() 
    {
        return this.stockVehiculos;
    }
    
    @Override
    public int contarMotoresDisponibles()
    {
        return this.stockMotores.size();
    }
    
    @Override 
    public int contarRuedasDisponibles()
    {
        return this.stockRuedas.size();
    }
    
    @Override
    public int contarTapiceriasDisponibles() 
    {
        return this.stockTapicerias.size();
    }
    
    @Override
    public int contarVehiculosEnStock()
    {
        return this.stockVehiculos.size();
    }
    
    //Faltan el resto de metodos de contar
    
    @Override
    public List<Operario> getOperariosDisponibles() 
    {
        List<Operario> operarios = new ArrayList();
        for (Trabajador t : plantillaTrabajadores) 
        {
            if (t instanceof Operario) 
            {
                operarios.add((Operario) t);
            }
        }
        
        return operarios;
    }
    
    @Override
    public List<MecanicoDeCinta> getMecanicosDisponibles()
    {
        List<MecanicoDeCinta> mecanicos = new ArrayList();
        for (Trabajador t : plantillaTrabajadores)
        {
            if (t instanceof MecanicoDeCinta)
            {
                mecanicos.add((MecanicoDeCinta) t);
            }
        }
        return mecanicos;
    }


}
