package java8.lambda;

public class ClienteRand {
    private void imprimeRand(IRand rand) {
        System.out.println("Rand: " + rand.getRand());
    }

    public static final void main(String [] args) {
        ClienteRand clienteRand = new ClienteRand();

        // método clásico
        IRand rand = new IRand() {
            @Override
            public double getRand() {
                return Math.random()*100;
            }
        };
        clienteRand.imprimeRand(rand);

        // lo mismo usando una expresión lambda
        clienteRand.imprimeRand(() -> Math.random()*100);

    }
}

