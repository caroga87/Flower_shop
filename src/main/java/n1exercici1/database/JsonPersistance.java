package n1exercici1.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonPersistance {

    public static <T> String saveToJson (String fileName, T object ){
        ObjectMapper mapper = new ObjectMapper();
        String data = null;
        try {
            mapper.writeValue(new File(fileName), object);
        }catch (IOException e){
            System.out.println("XXX");
        } return data;
    }

    public static <T> T loadFromJson (Class <T> object, String filename){
        ObjectMapper mapper = new ObjectMapper();
        T data = null;
        try {
            data = mapper.readValue(filename, object);
        }catch (IOException e){
            System.out.println("XXXX");
        }
        return data;
    }
}
