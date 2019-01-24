package java7.paralelismo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;import java.util.concurrent.RecursiveTask;

/**
 * Esta tarea suma los valores en el rango especificado
 */
public class Fibonacci extends RecursiveTask<Long> {
    private final long n;
    private final boolean usaParalelismo;

    public Fibonacci(long n, boolean usaParalelismo) {
        this.n = n;
        this.usaParalelismo = usaParalelismo;
    }

    private List<Fibonacci> creaSubtareas() {
        List<Fibonacci> subtareas = new ArrayList<>();
        subtareas.add(new Fibonacci(n-1, usaParalelismo));
        subtareas.add(new Fibonacci(n-2, usaParalelismo));
        return subtareas;
    }
    
    @Override
    protected Long compute() {
        if (n <= 1) {
            return n;
        }

        //fibonacci(n-1) + fibonacci(n-2)
        List<Fibonacci> subtareas = creaSubtareas();

        if (usaParalelismo) {
            long sum = 0;
            for (Fibonacci subtarea: subtareas) {
                sum += subtarea.join();
            }
            return sum;
        } else {
            long sum = 0;
            for (Fibonacci subtarea: subtareas) {
                sum += subtarea.compute();
            }
            return sum;

        }
    }
}


/* A partir de Java 8
return ForkJoinTask.invokeAll(subtareas)
        .stream()
        .mapToLong(ForkJoinTask::join)
        .sum();*/
