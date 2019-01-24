package java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class EjemploCompletableFuture {
    public static final void main(String [] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> futureCompletado = CompletableFuture.completedFuture("Futuro completado");
        CompletableFuture<String> futureCompletadoDespues = new CompletableFuture<>();
        // hacemos algo y luego lo ejecutamos
        futureCompletadoDespues.complete("Completado!");

        CompletableFuture<Void> futuroAsincrono = CompletableFuture.runAsync(() -> {
            System.out.println("Hacemos algo costoso que tarda 2s.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.err.println("Interrumpida la tarea costosa.");
            }
            System.out.println("Finalizada la tarea costosa.");
        }).thenAccept((Void) -> {System.out.println("Finalizado");});

        futuroAsincrono.get(); // hasta que no ejecutamos esto no se ejecuta realmente
    }
}

