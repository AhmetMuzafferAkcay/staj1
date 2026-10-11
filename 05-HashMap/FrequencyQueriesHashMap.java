import java.io.*;
import java.util.*;

public class FrequencyQueriesHashMap {

    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        
        // 1. Map: Elemanın kaç kez tekrar ettiğini tutar (Element -> Frequency)
        HashMap<Integer, Integer> elementFrequencyMap = new HashMap<>();
        
        // 2. Map: Belirli bir frekansta kaç farklı eleman olduğunu tutar (Frequency -> Count of elements)
        HashMap<Integer, Integer> frequencyCountMap = new HashMap<>();

        // Klasik for döngüsü ile sorguları tek tek işle
        for (int i = 0; i < queries.size(); i++) {
            int queryType = queries.get(i).get(0);
            int value = queries.get(i).get(1);

            if (queryType == 1) {
                // --- EKLEME İŞLEMİ (Insert) ---
                int currentFreq = elementFrequencyMap.getOrDefault(value, 0);
                
                // Eski frekansın count değerini bir azalt (Eğer varsa)
                if (currentFreq > 0) {
                    frequencyCountMap.put(currentFreq, frequencyCountMap.get(currentFreq) - 1);
                }
                
                // Yeni frekansı güncelle
                int newFreq = currentFreq + 1;
                elementFrequencyMap.put(value, newFreq);
                
                // Yeni frekansın count değerini bir artır
                frequencyCountMap.put(newFreq, frequencyCountMap.getOrDefault(newFreq, 0) + 1);

            } else if (queryType == 2) {
                // --- SİLME İŞLEMİ (Delete) ---
                if (elementFrequencyMap.containsKey(value)) {
                    int currentFreq = elementFrequencyMap.get(value);
                    
                    // Eski frekansın count değerini bir azalt
                    frequencyCountMap.put(currentFreq, frequencyCountMap.get(currentFreq) - 1);
                    
                    if (currentFreq > 1) {
                        int newFreq = currentFreq - 1;
                        elementFrequencyMap.put(value, newFreq);
                        frequencyCountMap.put(newFreq, frequencyCountMap.getOrDefault(newFreq, 0) + 1);
                    } else {
                        // Frekans 1'den küçük ol independiente elemanı tamamen kaldır
                        elementFrequencyMap.remove(value);
                    }
                }

            } else if (queryType == 3) {
                // --- KONTROL İŞLEMİ (Check Frequency) ---
                // Eğer aranan frekanstan en az 1 tane varsa 1 ekle, yoksa 0 ekle
                if (frequencyCountMap.getOrDefault(value, 0) > 0) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            List<Integer> query = new ArrayList<>();
            query.add(scanner.nextInt());
            query.add(scanner.nextInt());
            queries.add(query);
        }

        scanner.close();

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
