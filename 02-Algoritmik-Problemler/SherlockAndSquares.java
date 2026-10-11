import java.util.Scanner;

public class SherlockAndSquares {

    public static int squares(int a, int b) {
        // a ve b arasındaki tam kare sayısını bulmak için:
        // Alt sınırın karekökünün yukarı yuvarlanmış hali ile üst sınırın karekökünün aşağı yuvarlanmış hali arasındaki fark alınır.
        int start = (int) Math.ceil(Math.sqrt(a));
        int end = (int) Math.floor(Math.sqrt(b));

        // Toplam kare sayısı
        int count = end - start + 1;
        
        // Eğer end < start durumu oluşursa (arada hiç tam kare yoksa) sonuç 0 olmalıdır.
        if (count < 0) {
            return 0;
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt(); // Test case (sorgu) sayısı

        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int result = squares(a, b);
            System.out.println(result);
        }

        scanner.close();
    }
}
