package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ficheros {
    public static final void main(String [] args) throws IOException {
        var words = "forest\nwood\nsky\nrock";
        Files.writeString(Path.of("/tmp/words.txt"), words);

        var datosLeidos = Files.readString(Path.of("/tmp/words.txt"));

        System.out.println("Datos leídos: " + datosLeidos);
    }
}
