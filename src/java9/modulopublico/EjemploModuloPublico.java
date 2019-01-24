package java9.modulopublico;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploModuloPublico {
    public void metodoImportante() {
        Logger.getLogger(EjemploModuloPublico.class.getName()).log(Level.INFO, "Usando módulos");
    }
}
