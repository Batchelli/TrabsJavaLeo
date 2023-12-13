import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] fibonacci = new int [22];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        System.out.println("Sequência de Fibonacci: ");

        for (int i = 0; i < fibonacci.length; i++) {
            fibonacci[i+2] = fibonacci[i + 1] + fibonacci[i];
            System.out.println(fibonacci[i]);
        }

    }
}