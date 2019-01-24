package java9.reactive;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PublicadorDeMensajes implements Flow.Publisher {
    private static final int NB_THREADS = 2;
    private final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NB_THREADS);
    private SubmissionPublisher<Mensaje> sb = new SubmissionPublisher<Mensaje>(EXECUTOR, Flow.defaultBufferSize());
    int nultimoMensaje = 0;
    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Alguien se ha suscrito");
        sb.subscribe(subscriber);
    }

    public void publicaMensajes() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NB_THREADS);

        Runnable tareaEnvioMensajes = () -> {
            int nmensajes = (int) (Math.random()*5);
            for (int i=0; i<nmensajes; i++) {
                Mensaje mensaje = new Mensaje("Mensaje #" + nultimoMensaje);
                nultimoMensaje++;
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Enviando mensaje {0}", mensaje);
                sb.submit(mensaje);
            }
        };

        long delay = 3;
        executor.scheduleWithFixedDelay(tareaEnvioMensajes, 2, 5, TimeUnit.SECONDS);
    }
}

