package co.edu.unicauca.presentacion;

import co.edu.unicauca.modelo.FabricaServidor;
import co.edu.unicauca.modelo.PlantillaServidor;
import java.util.Scanner;

/**
 *
 * @author lmarango
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            String servidor="";
            int puerto=0;
            FabricaServidor fabrica = new FabricaServidor();
            System.out.println("======== SELECCIÓN TIPO DE SERVIDOR ==========");
            System.out.println("Digite el tipo de servidor que desea utilizar");
            System.out.println("En caso de no seleccionar, se creará por defecto un servidor asincrónico");
            System.out.println("\nsincronico \t asincronico");
            servidor = reader.nextLine();
            System.out.println("\nDigite el puerto de escucha: ");
            puerto = reader.nextInt();
            PlantillaServidor s_recursos = fabrica.getServer(servidor);
            s_recursos.ServidorInicializacion(puerto);
            s_recursos.ejecutarServidor();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
