package java8.completableFuture;

import java.util.concurrent.*;

public class EjemploFuture {
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public Future<Boolean> enviarMensaje(String msg) {
        return executor.submit(() -> {
            int delay = (int) (Math.random()*3);
            System.out.println("Enviando " + msg + " que tardará " + delay + "s.");
            TimeUnit.SECONDS.sleep(delay); // simulamos la espera entre 0 y 3s
            return true;
        });
    }

    public static final void main(String [] args) throws ExecutionException, InterruptedException {
        EjemploFuture ejemploFuture = new EjemploFuture();
        for (int i=0; i<5; i++) {
            Future<Boolean> futuro = ejemploFuture.enviarMensaje("Mensaje #" + i);
            try {
                boolean enviado = futuro.get(1, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                System.err.println("Timeout (1s.) en envío #" + i);
            }
        }
    }
}
