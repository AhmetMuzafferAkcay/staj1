import java.util.Scanner;

public class LibraryFine {

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // 1. Durum: Teslim yılı, son teslim tarihinden sonraysa sabit 10000 ceza uygulanır.
        if (y1 > y2) {
            return 10000;
        }
        // Eğer teslim yılı daha erkense ceza yoktur.
        if (y1 < y2) {
            return 0;
        }

        // 2. Durum: Yıllar aynı, ancak teslim ayı son teslim ayından sonraysa,
        // geciken her ay için 500 birim ceza uygulanır.
        if (m1 > m2) {
            return 500 * (m1 - m2);
        }
        // Eğer ay daha erkense ceza yoktur.
        if (m1 < m2) {
            return 0;
        }

        // 3. Durum: Yıllar ve aylar aynı, ancak teslim günü son teslim gününden sonraysa,
        // geciken her gün için 15 birim ceza uygulanır.
        if (d1 > d2) {
            return 15 * (d1 - d2);
        }

        // Eğer kitap zamanında veya erken teslim edilmişse ceza yoktur.
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Geri getirilme tarihi (d1, m1, y1)
        int d1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        // Son teslim tarihi (d2, m2, y2)
        int d2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        scanner.close();

        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
    }
}
