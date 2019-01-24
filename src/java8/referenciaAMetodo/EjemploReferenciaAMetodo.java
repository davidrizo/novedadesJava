package java8.referenciaAMetodo;

import java.util.ArrayList;

public class EjemploReferenciaAMetodo {
    public static final void main(String [] args) {
        ArrayList<Person> personas = new ArrayList<>();
        // insertamos personas

        ComparisonProvider comparisonProvider = new ComparisonProvider();
        personas.sort(comparisonProvider::compareByAge);

        personas.sort(ComparisonProviderEstatico::compareByAge);
    }
}
