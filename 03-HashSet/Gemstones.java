import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Gemstones {

    public static int gemstones(List<String> arr) {
        // İlk kayaçtaki (string'deki) benzersiz karakterleri tutmak için bir HashSet oluştur
        HashSet<Character> commonChars = new HashSet<>();
        String firstString = arr.get(0);
        
        for (int i = 0; i < firstString.length(); i++) {
            commonChars.add(firstString.charAt(i));
        }

        // Diğer kayaçları klasik for döngüsü ile dolaş
        for (int i = 1; i < arr.size(); i++) {
            HashSet<Character> currentChars = new HashSet<>();
            String currentString = arr.get(i);
            
            for (int j = 0; j < currentString.length(); j++) {
                currentChars.add(currentString.charAt(j));
            }
            
            // Sadece tüm kayaçlarda ortak olan karakterleri tut (Kesişim - retainAll)
            commonChars.retainAll(currentChars);
        }

        // Geriye kalan ortak (gemstone) karakter sayısını dön
        return commonChars.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(scanner.next());
        }

        scanner.close();

        int result = gemstones(arr);
        System.out.println(result);
    }
}
