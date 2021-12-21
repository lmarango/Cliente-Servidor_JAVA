package co.edu.unicauca.modelo;

/**
 *
 * @author lmarango
 */
public class FabricaServidor {
    public PlantillaServidor getServer(String servidorSeleccionado){
        switch (servidorSeleccionado) {
            case "sincronico" : return new ServidorSincronico();
            case "asincronico" : return new ServidorAsincronico();
            default: return new ServidorAsincronico();
        }
    }
}
