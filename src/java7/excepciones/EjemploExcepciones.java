package java7.excepciones;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploExcepciones {
    private void F(int x) throws IOException, ParseException {
        if (x == 0) {
            throw new IOException("x=0");
        } else if (x == 1) {
            throw new ParseException("x=1", 1);
        }
    }

    private void G(int x) throws IOException, ParseException {
        try {
            F(x);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "No he podido ... ", x);
            throw e;
        }
    }

    public static final void main(String [] args) {
        EjemploExcepciones e = new EjemploExcepciones();
        try {
            e.F(2);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }
}
