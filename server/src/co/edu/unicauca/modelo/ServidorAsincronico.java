package co.edu.unicauca.modelo;

/**
 *
 * @author lmarango
 */
public class ServidorAsincronico extends PlantillaServidor{

    public ServidorAsincronico() {}
    
    @Override
    public void conectarclient() {
        try {
            if(objservidor.isClosed()){
                return;
            }
            while (true) {
                setObjsocket(objservidor.accept());
                System.out.println("Cliente conectado");
                new GestorDeHilo(getObjsocket(), this).start();
            }
        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }
    
}
