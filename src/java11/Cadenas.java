package java11;

public class Cadenas {
    public static final void main(String [] args) {
        var word = "falcon ";
        System.out.println(word.repeat(5));
        var word2 = "\tnice blue\t";
        System.out.println(word2 + "sky");
        System.out.println(word2.stripTrailing() + "sky");
        System.out.println(word2.stripLeading() + "sky");
        System.out.println(word2.strip() + "sky");
        var word3 = "  ";
        System.out.println(word3.isEmpty());
        System.out.println(word3.isBlank());
        var words = "falcon\neagle\nsky\nwood\nforest";
        words.lines().forEach(System.out::println);
    }
}
