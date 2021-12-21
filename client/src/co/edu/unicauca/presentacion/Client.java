package co.edu.unicauca.presentacion;

import co.edu.unicauca.modelo.InformacionDTO;
import co.edu.unicauca.servicios.Conexion_cliente_servidor;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion_cliente_servidor cliente = new Conexion_cliente_servidor();
        InformacionDTO informacion = new InformacionDTO();
        int option = -1;
        int puerto=0;
        String dirIP="";
        Scanner reader = new Scanner(System.in);
        do{
            System.out.println("===== M E N U  C L I E N T E =====");
            System.out.println("1. Conectarse");
            System.out.println("2. Consultar características");
            System.out.println("3. salir\n");
            System.out.println("Digite su opción: ");
            option = reader.nextInt();
            switch(option){
                case 1 : 
                    System.out.println("Ingrese La direccion IP: ");
                    dirIP = reader.next();
                    System.out.println("Ingrese el puerto: ");
                    puerto = reader.nextInt();
                    try {
                        cliente.ServerConnection(dirIP,puerto);
                    } catch(Exception e){
                        System.out.println("\nError: "+e.getMessage());
                    }    
                    break;
                case 2 : 
                    informacion = cliente.peticion_respuesta();
                    System.out.println("====== RESULTADO CONSULTA ======");
                    System.out.print("Nombre del usuario: ");
                    System.out.println(informacion.getNombreUsuario());
                    System.out.print("Directorio del usuario: ");
                    System.out.println(informacion.getDirUsuario());
                    System.out.println("=== Procesos ====");
                    System.out.println(informacion.getProcesos());
                    System.out.println("=================\n");
                    break;
                default : 
                    System.out.println("Opción inválida");
                    break;
            }
        }while(option != 3);
    }
    
}
