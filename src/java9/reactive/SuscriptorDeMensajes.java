package java9.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuscriptorDeMensajes implements Flow.Subscriber<Mensaje>  {
    private static final long NITEMS = 5;
    private Flow.Subscription subscription;
    String nombre;

    public SuscriptorDeMensajes(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "{0} se ha suscrito", nombre);
        this.subscription = subscription;
        subscription.request(NITEMS);
    }

    @Override
    public void onNext(Mensaje item) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Siguiente mensaje {0} recibido por {1}",
                new Object[]{item, nombre});

        try {
            TimeUnit.SECONDS.sleep(1); // esperamos 1s
        } catch (InterruptedException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Espera interrumpida", e);
        }

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Solicitando {0} items de la suscripción de {1}",
                new Object[]{NITEMS, nombre});
        subscription.request(NITEMS);
    }

    @Override
    public void onError(Throwable throwable) {
        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Error en la suscripción", throwable);
    }

    @Override
    public void onComplete() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Suscripción de {0} completada", nombre);
    }
}
