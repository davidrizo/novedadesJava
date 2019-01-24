package java7.trycatchrecursos;

public class EjemploTryCatchRecurso {
    public static final void main(String [] args) {
        try (Luz luz = new Luz()) {
            System.out.println("Entro en el try");
            luz.cambiaIntensidad(-20);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
