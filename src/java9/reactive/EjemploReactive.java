package java9.reactive;

public class EjemploReactive {
    public static final void main(String [] args) {
        PublicadorDeMensajes publicadorDeMensajes = new PublicadorDeMensajes();

        SuscriptorDeMensajes suscriptorDeMensajesA = new SuscriptorDeMensajes("Receptor A");
        SuscriptorDeMensajes suscriptorDeMensajesB = new SuscriptorDeMensajes("Receptor B");

        publicadorDeMensajes.subscribe(suscriptorDeMensajesA);
        publicadorDeMensajes.subscribe(suscriptorDeMensajesB);

        publicadorDeMensajes.publicaMensajes();

    }
}
