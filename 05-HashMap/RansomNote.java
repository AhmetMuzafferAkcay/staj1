import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class RansomNote {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        HashMap<String, Integer> magazineMap = new HashMap<>();

        // Dergideki kelimeleri ve kaç kez geçtiklerini HashMap'e kaydet
        for (int i = 0; i < magazine.size(); i++) {
            String word = magazine.get(i);
            magazineMap.put(word, magazineMap.getOrDefault(word, 0) + 1);
        }

        // Notteki kelimelerin dergide yeterli miktarda olup olmadığını kontrol et
        for (int i = 0; i < note.size(); i++) {
            String word = note.get(i);

            // Eğer kelime dergide yoksa veya sayısı 0'a düşmüşse ransom note oluşturulamaz
            if (!magazineMap.containsKey(word) || magazineMap.get(word) <= 0) {
                System.out.println("No");
                return;
            }

            // Kullanılan kelimenin stoğunu 1 azalt
            magazineMap.put(word, magazineMap.get(word) - 1);
        }

        // Tüm kelimeler yeterli sayıdaysa Yes yazdır
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt(); // Dergideki kelime sayısı
        int n = scanner.nextInt(); // Notteki kelime sayısı

        List<String> magazine = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            magazine.add(scanner.next());
        }

        List<String> note = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            note.add(scanner.next());
        }

        scanner.close();

        checkMagazine(magazine, note);
    }
}
