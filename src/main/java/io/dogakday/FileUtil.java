package io.dogakday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
    public static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (InputStream is = FileUtil.class.getResourceAsStream("/" + fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static List<String> filterWordsByLength(List<String> words, int length) {
        return words.stream()
                .filter(word -> word.length() == length)
                .collect(Collectors.toList());
    }
}
