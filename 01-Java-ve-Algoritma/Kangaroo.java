import java.util.Scanner;

public class Kangaroo {

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Eğer arkadaki kangurunun hızı öndekinden küçükse veya eşitse, 
        // aradaki mesafe hiç kapanmaz ve asla yetişemezler.
        if (v1 <= v2) {
            return "NO";
        }
        
        // Matematiksel olarak: x1 + v1 * n = x2 + v2 * n 
        // n (zıplama sayısı) tam sayı olmalıdır. 
        // Yani toplam mesafe farkı hızlar farkına tam bölünmelidir.
        if ((x2 - x1) % (v1 - v2) == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();

        scanner.close();

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);
    }
}
