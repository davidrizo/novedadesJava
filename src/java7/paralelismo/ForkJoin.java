package java7.paralelismo;

import java.util.Date;

public class ForkJoin {

    public void run(long n, boolean usarForkJoin) {
        Date t0 = new Date();
        System.out.println("¿Usar paralelismo?: " + usarForkJoin);
        Fibonacci fibonacci = new Fibonacci(n, false);
        Long resultado = fibonacci.compute();
        Date t1= new Date();
        System.out.println("Nº de Fibonacci: " + resultado);
        System.out.println("Tiempo tardado: " +
                (t1.getTime() - t0.getTime()) + " milisegundos");
    }

    public static final void main(String [] args) {
        ForkJoin forkJoin = new ForkJoin();
        long n = 25;
        forkJoin.run(n, false);
        forkJoin.run(n, true);
    }
}
