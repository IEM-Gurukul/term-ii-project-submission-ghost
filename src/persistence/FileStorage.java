package persistence;

import java.io.*;

public class FileStorage {

    public static void save(String fileName, String data) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write(data);
        writer.close();
    }

    public static String load(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder data = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null) {
            data.append(line);
        }

        reader.close();
        return data.toString();
    }
}