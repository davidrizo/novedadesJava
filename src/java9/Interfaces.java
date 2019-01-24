package java9;

public interface Interfaces {
    default void F() {
        metodoAImplementar();
        metodoAuxiliar();
    }

    void metodoAImplementar();

    private void metodoAuxiliar() {
    }
}
