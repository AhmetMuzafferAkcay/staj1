import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    public static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.ONE;

        // Klasik for döngüsü ile 1'den n'e kadar sayıları çarp
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Sonucu ekrana yazdır
        System.out.println(factorial);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.close();

        extraLongFactorials(n);
    }
}
