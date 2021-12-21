package co.edu.unicauca.modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author lmarango
 */
public class GestorDeHilo extends Thread{
    private Socket objSocketCliente;
    private PlantillaServidor servidor;
    
    public GestorDeHilo(Socket objSocket, PlantillaServidor servidor){
        this.objSocketCliente = objSocket;
        this.servidor = servidor;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Atendiendo hilo de cliente");
            DataInputStream flujoEntrada;
            DataOutputStream flujoSalida;
            String message;
            flujoEntrada=new DataInputStream(objSocketCliente.getInputStream());
            flujoSalida=new DataOutputStream(objSocketCliente.getOutputStream());
            message = flujoEntrada.readUTF();//se bloquea el servidor
            flujoSalida.writeUTF(servidor.atenderPeticion());
            objSocketCliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Socket getClntSocket() {
        return objSocketCliente;
    }

    public void setClntSocket(Socket clntSocket) {
        this.objSocketCliente = clntSocket;
    }
}
