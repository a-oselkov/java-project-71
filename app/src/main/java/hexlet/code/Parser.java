package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> fileToMap(String filePath) throws IOException {
        String fileType = filePath.substring(filePath.length() - 4);
        ObjectMapper objectMapper = fileType.equals("json") ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        Map<String, Object> data = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        return data;
    }
}
