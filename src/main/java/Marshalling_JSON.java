import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Marshalling_JSON {
    public static void MarshallingJson(List<casetaFeria> casetasList) {
        String jsonFile = "casetas.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();//Creamos el objeto Mapper

            casetas casetas = new casetas(casetasList); //Creamos el objeto casetas y introduzco la lista de casetas para pasarlo a Json

            objectMapper.writeValue(new File(jsonFile), casetas); //Creamos el archivo Json
            System.out.println("Objeto casetas serializado a JSON");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void UnmarshallingJson(String JsonPath) {

        try {
            ObjectMapper objectMapper = new ObjectMapper(); //Creamos el objeto Mapper
            casetas casetasfromJson = objectMapper.readValue(new File(JsonPath), casetas.class); //Leemos el archivo Json y le especificamos la clase q esta leyendo

            System.out.println("Objeto Casetas después de deserializar:");
            System.out.println(casetasfromJson.toString()); //Y lo mostramos
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarCasetaX(String JsonPath, int x) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            casetas casetasfromJson = objectMapper.readValue(new File(JsonPath), casetas.class);

            System.out.println(casetasfromJson.getCasetasList().stream().filter(casetaFeria -> casetaFeria.getId() == x).findFirst().orElseThrow(IOException::new));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
