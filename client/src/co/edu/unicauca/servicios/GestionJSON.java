package co.edu.unicauca.servicios;

import co.edu.unicauca.modelo.InformacionDTO;
import com.google.gson.Gson;

/**
 *
 * @author lmarango
 */
public class GestionJSON {
    public static InformacionDTO JsonToObject(String json){
        Gson gson = new Gson();
        InformacionDTO response = new InformacionDTO();
        response = gson.fromJson(json, InformacionDTO.class);
        return response;
    }
}
