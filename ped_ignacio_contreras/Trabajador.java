
import java.util.Date;

public abstract class Trabajador
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String numSeguridadSocial;
    private String puesto;
    private double salario;
    private Date fechaIngreso;

    /**
     * Constructor for objects of class Trabajador
     */
Trabajador(String nombre, String apellidos, String dni, String direccion, String numSeguridadSocial, String puesto, double salario, Date fechaIngreso)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.numSeguridadSocial = numSeguridadSocial;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    
    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}
    
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    
    public String getNumSeguridadSocial() {return numSeguridadSocial;}
    public void setNumSeguridadSocial(String numSeguridadSocial) {this.numSeguridadSocial = numSeguridadSocial;}
    
    public String getPuesto() {return puesto;}
    public void setPuesto(String puesto) {this.puesto = puesto;}
    
    public double getSalario() {return salario;}
    public void setSalario(double salario) {this.salario = salario;}
    
    public Date getFechaIngreso(){return fechaIngreso;}
    public void setFechaIngreso(Date fechaIngreso) {this.fechaIngreso = fechaIngreso;}
}
class Operario extends Trabajador 
    {
        private int montajesRealizados;
        
        public Operario(String nombre, String apellidos, String dni, String direccion, String numSeguridadSocial, double salario, Date fechaIngreso) 
        {
            super(nombre, apellidos, dni, direccion, numSeguridadSocial, "Operario", salario, fechaIngreso);
            this.montajesRealizados = 0;
        }
        
        public boolean isEficiente() 
        {
            return montajesRealizados > 10;
        }
        
        public void registrarMontaje() 
        {
            this.montajesRealizados++;
        }
    }
    
class MecanicoDeCinta extends Trabajador
    {
        private int reparacionesRealizadas;
        
        public MecanicoDeCinta(String nombre, String apellidos, String dni, String direccion, String numSeguridadSocial, double salario, Date fechaIngreso)
        {
            super(nombre, apellidos, dni, direccion, numSeguridadSocial, "Mecanico de cinta", salario, fechaIngreso);
            this.reparacionesRealizadas = 0;
        }
        
        public boolean isEfectivo() 
        {
            return reparacionesRealizadas > 20;
        }
        
        public void registrarReparacion() 
        {
            this.reparacionesRealizadas++;
        }
    }
    
class GestorDePlanta extends Trabajador 
    {
        public GestorDePlanta(String nombre, String apellidos, String dni, String direccion, String numSeguridadSocial, double salario, Date fechaIngreso)
        {
            super(nombre, apellidos, dni, direccion, numSeguridadSocial, "Gestor de planta", salario, fechaIngreso);
        }
    }
    
class AdministradorDelSistema extends Trabajador 
    {
        public AdministradorDelSistema(String nombre, String apellidos, String dni, String direccion, String numSeguridadSocial, double salario, Date fechaIngreso)
        {
            super(nombre, apellidos, dni, direccion, numSeguridadSocial, "Administrador del sistema", salario, fechaIngreso);
        }
    }
    