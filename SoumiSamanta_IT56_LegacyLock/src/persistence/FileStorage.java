package persistence;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileStorage {

    public static void storeFile(File source,String destination) throws IOException{

        File dest=new File(destination);

        Files.copy(source.toPath(),dest.toPath());
    }
}