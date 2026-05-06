public enum EstadoVehiculo
{
    CHASIS,     // Fase inicial: el vehículo entra como chasis
    MOTOR,      // Fase 2: ensamblaje del motor
    TAPICERIA,  // Fase 3: instalación de la tapicería
    RUEDAS,     // Fase 4: montaje de las ruedas
    TERMINADO   // Fase final: vehículo completado y fuera de la cadena
}