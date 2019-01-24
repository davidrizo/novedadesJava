package java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;

public class EjemploComparator {
    public static final void main(String [] args) {
        ArrayList<Integer> v = new ArrayList<>();
        for (int i=0; i<20; i++) {
            v.add((int) (Math.random()*100));
        }

        // forma nueva
        v.sort((o1, o2) -> o1 - o2);
        System.out.println(v);
    }
}


// forma antigua
/*        v.sort(new Comparator<Integer>() {
@Override
public int compare(Integer o1, Integer o2) {
        return o1 - o2;
        }
        });

*/



