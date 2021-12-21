package co.edu.unicauca.servicios;

import co.edu.unicauca.modelo.InformacionDTO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author lmarango
 */
public class Conexion_cliente_servidor {
    private String dirIpServidor = "";
    private int puertoServidor;
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    private Socket socket;
    private InformacionDTO message;

    public void ServerConnection(String dirIP, int puerto){
        try {
            setDirIpServidor(dirIP);
            setPuertoServidor(puerto);
            setSocket(new Socket(dirIP, puerto));
            setFlujoEntrada(new DataInputStream(getSocket().getInputStream()));
            setFlujoSalida(new DataOutputStream(getSocket().getOutputStream()));
        } catch (IOException excep) {
            excep.printStackTrace();
        }
    }
    
    public InformacionDTO peticion_respuesta(){
        String tmp = null;
        try {
            flujoSalida.writeUTF("caracteristicas");
            tmp = flujoEntrada.readUTF();// operacion bloqueante
            message = GestionJSON.JsonToObject(tmp);
            getSocket().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return getMessage();
    }

    public String getDirIpServidor() {
        return dirIpServidor;
    }

    public void setDirIpServidor(String dirIpServidor) {
        this.dirIpServidor = dirIpServidor;
    }

    public int getPuertoServidor() {
        return puertoServidor;
    }

    public void setPuertoServidor(int puertoServidor) {
        this.puertoServidor = puertoServidor;
    }

    public DataInputStream getFlujoEntrada() {
        return flujoEntrada;
    }

    public void setFlujoEntrada(DataInputStream flujoEntrada) {
        this.flujoEntrada = flujoEntrada;
    }

    public DataOutputStream getFlujoSalida() {
        return flujoSalida;
    }

    public void setFlujoSalida(DataOutputStream flujoSalida) {
        this.flujoSalida = flujoSalida;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public InformacionDTO getMessage() {
        return message;
    }

    public void setMessage(InformacionDTO message) {
        this.message = message;
    }
}
