import java.util.Scanner;

public class AppleAndOrange {

    public static void countApplesAndOranges(int s, int t, int a, int b, int apples[], int oranges[]) {
        int appleCount = 0;
        int orangeCount = 0;

        // Elmaların düştüğü konumları kontrol et
        for (int i = 0; i < apples.length; i++) {
            int landingPosition = a + apples[i];
            if (landingPosition >= s && landingPosition <= t) {
                appleCount++;
            }
        }

        // Portakalların düştüğü konumları kontrol et
        for (int i = 0; i < oranges.length; i++) {
            int landingPosition = b + oranges[i];
            if (landingPosition >= s && landingPosition <= t) {
                orangeCount++;
            }
        }

        // Sonuçları yazdır
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] apples = new int[m];
        for (int i = 0; i < m; i++) {
            apples[i] = scanner.nextInt();
        }

        int[] oranges = new int[n];
        for (int i = 0; i < n; i++) {
            oranges[i] = scanner.nextInt();
        }

        scanner.close();

        countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}
