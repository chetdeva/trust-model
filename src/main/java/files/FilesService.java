package files;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;

public class FilesService {

    private final ClassLoader classLoader;
    private final Gson gson;

    private FilesService(ClassLoader classLoader, Gson gson) {
        this.classLoader = classLoader;
        this.gson = gson;
    }

    private String getFilePath(String fileName) {
        URL resource = classLoader.getResource(fileName);
        if (resource.getFile() != null) {
            return resource.getFile();
        }
        return null;
    }

    public <T> T read(String fileName, Type type) {
        String filePath = getFilePath(fileName);
        try (FileReader fileReader = new FileReader(filePath)) {
            JsonReader jsonReader = new JsonReader(fileReader);
            return gson.fromJson(jsonReader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static FilesService filesService;

    public static FilesService getInstance(ClassLoader classLoader, Gson gson) {
        if (filesService == null) {
            filesService = new FilesService(classLoader, gson);
        }
        return filesService;
    }
}
