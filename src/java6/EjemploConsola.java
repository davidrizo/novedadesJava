package java6;

import java.io.Console;

public class EjemploConsola {
    public static final void main(String [] args) throws Exception {
        Console con = System.console();

        if (con == null) {
            throw new Exception("No puedo encontrar la consola");
        }
        // Read a string and then display it.
        String str = con.readLine("Enter your name: ");
        con.printf("Here is your name: %s\n", str);
        //to read password and then display it
        System.out.println("Enter the password: ");
        char[] ch=con.readPassword();

        //converting char array into string
        String pass = String.valueOf(ch);
        System.out.println("Password is: " + pass);
    }
}
