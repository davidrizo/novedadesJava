package java7.trycatchrecursos;

import java.io.Closeable;
import java.io.IOException;

public class Luz implements Closeable {
    public void open() {
        System.out.println("Estoy abriendo");
    }

    @Override
    public void close() throws IOException {
        System.out.println("Estoy cerrando");
    }

    public void cambiaIntensidad(int intensidad) throws Exception {
        if (intensidad < 0) {
            throw new Exception("Intensidad negativa inválida: " + intensidad);
        }
    }
}
