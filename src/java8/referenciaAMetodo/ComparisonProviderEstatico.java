package java8.referenciaAMetodo;

public class ComparisonProviderEstatico {
    public static int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    public static int compareByAge(Person a, Person b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }
}