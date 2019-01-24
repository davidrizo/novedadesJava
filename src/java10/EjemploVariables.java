package java10;

public class EjemploVariables {
    public static final void main(String [] args) {
        var texto = "Hola";
        //texto = new Object(); // esto daría error
        System.out.println(texto.getClass().toString());
    }
}
