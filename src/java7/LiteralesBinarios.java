package java7;

public class LiteralesBinarios {
    public static void main(String[] args) {
        int i=0b0111;
        byte b=(byte) 0b0111;
        long l=(long) 0B0111L;
        long creditCardNumber = 1234_5678_9012_3456L;

        System.out.println("i="+i);
        System.out.println("b="+b);
        System.out.println("l="+l);
        System.out.println("CC=" + creditCardNumber);
    }
}
