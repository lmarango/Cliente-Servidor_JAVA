package co.edu.unicauca.modelo;

import co.edu.unicauca.servicios.ConversorJson;
import co.edu.unicauca.servicios.GestorPeticion;
import co.edu.unicauca.servicios.InformacionDTO;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lmarango
 */
public abstract class PlantillaServidor {
    private int PUERTO;
    protected ServerSocket objservidor;
    protected Socket objsocket;

    public PlantillaServidor(){}
    
    public abstract void conectarclient();
    
    public void ejecutarServidor(){
        conectarclient();
    }
    
    public boolean ServidorInicializacion(int prmPuerto){
        try {
            setPUERTO(prmPuerto);
            objservidor = new ServerSocket(PUERTO);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String atenderPeticion(){
        InformacionDTO informacion = new InformacionDTO();
        GestorPeticion peticion = new GestorPeticion();
        informacion.setNombreUsuario(peticion.getNombreUsuario());
        informacion.setDirUsuario(peticion.getDirectorioInicioUsuario());
        informacion.setProcesos(peticion.getProcesos());
        return ConversorJson.objectToJson(informacion);
    }

    public ServerSocket getObjservidor() {
        return objservidor;
    }

    public void setObjservidor(ServerSocket objservidor) {
        this.objservidor = objservidor;
    }

    public Socket getObjsocket() {
        return objsocket;
    }

    public void setObjsocket(Socket objsocket) {
        this.objsocket = objsocket;
    }

    public int getPUERTO() {
        return PUERTO;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }
    
    
}
