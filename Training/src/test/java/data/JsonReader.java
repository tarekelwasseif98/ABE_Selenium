package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonReader<T> {
    private final Class<T> targetType;
    
    public JsonReader(Class<T> targetType) {
        this.targetType = targetType;
    }

    public List<T> readJsonFile(String jsonFilePath) {
        try (FileReader reader = new FileReader(jsonFilePath)) {
            Gson gson = new Gson();
            Type listType = TypeToken.getParameterized(List.class, targetType).getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}