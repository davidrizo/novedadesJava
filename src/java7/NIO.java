package java7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO {
    public static final void main(String [] args) {
        Path path = Paths.get("No existo");
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.err.println("No he podido borrar: " + e);
        }
    }
}
