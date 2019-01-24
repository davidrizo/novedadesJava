package java9.reactive;

public class Mensaje {
    String contenido;

    public Mensaje(String s) {
        this.contenido = s;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return contenido;
    }
}
