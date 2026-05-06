import java.util.List;
import Componentes.Motor;
import Componentes.Tapiceria;
import Componentes.Rueda;

public interface IAlmacen
{
    // Gestion de trabajadores
    void registrarTrabajador(Trabajador t);
    List<Trabajador> getTrabajadores();
    
    // Gestion de componentes
    void almacenarMotor(Motor m);
    void almacenarTapiceria(Tapiceria t);
    void almacenarRueda(Rueda r);
    
    // Gestion de vehiculos
    void almacenarVehiculo(Vehiculo v);
    List<Vehiculo> getVehiculosEnStock();
}