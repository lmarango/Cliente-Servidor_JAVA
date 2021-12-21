package co.edu.unicauca.modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author lmarango
 */
public class ServidorSincronico extends PlantillaServidor{

    public ServidorSincronico() {}
    
    @Override
    public void conectarclient() {
        DataInputStream inputStream;
        DataOutputStream outputStream;
        String message;
        try {
            if(objservidor.isClosed()){
                return;
            }
            while (true) {
                objsocket = objservidor.accept();
                System.out.println("Cliente conectado");
                inputStream = new DataInputStream(objsocket.getInputStream());
                outputStream=new DataOutputStream(objsocket.getOutputStream());
                message = inputStream.readUTF();//se bloquea el servidor
                if(message.equals("caracteristicas")){
                    message = atenderPeticion();
                    outputStream.writeUTF(message);
                }
                objsocket.close();
            }
        } catch (IOException excep) {
            excep.printStackTrace();
        }
    }
}
