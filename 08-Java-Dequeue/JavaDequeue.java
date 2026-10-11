import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // n: toplam eleman sayısı, m: alt dizi (subarray) boyutu
        int n = in.nextInt();
        int m = in.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxUnique = 0;

        // Klasik for döngüsü ile diziyi tarıyoruz
        for (int i = 0; i < n; i++) {
            // 1. Yeni elemanı deque'e ve haritaya ekle
            deque.addLast(arr[i]);
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

            // 2. Pencere boyutu m'yi aştığında, soldaki eski elemanı pencereden çıkar
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                frequencyMap.put(removed, frequencyMap.get(removed) - 1);
                
                // Eğer silinen elemanın frekansı 0 olduysa haritadan tamamen kaldır
                if (frequencyMap.get(removed) == 0) {
                    frequencyMap.remove(removed);
                }
            }

            // 3. Pencere boyutu tam m olduğunda benzersiz eleman sayısını kontrol et
            if (deque.size() == m) {
                int currentUniqueCount = frequencyMap.size();
                if (currentUniqueCount > maxUnique) {
                    maxUnique = currentUniqueCount;
                }
            }
        }

        System.out.println(maxUnique);
    }
}
