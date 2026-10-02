package service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static String[] readFile(String url) throws Exception {

        List<String> result = new ArrayList<>();

        for (String line : Files.readAllLines(Path.of(url))) {
            if (line.contains(",")) {
                result.add(line);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void writeFile(String url, String content) throws Exception {

        Files.write(
                Path.of(url),
                content.getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}