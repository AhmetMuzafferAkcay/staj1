import java.io.*;
import java.util.*;

public class FrequencyQueriesTreeMap {

    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        
        // 1. Map: Elemanın kaç kez tekrar ettiğini tutar (Element -> Frequency)
        HashMap<Integer, Integer> elementFrequencyMap = new HashMap<>();
        
        // 2. TreeMap: Belirli bir frekansta kaç farklı eleman olduğunu tutur ve frekansları sıralı tutar (Frequency -> Count)
        TreeMap<Integer, Integer> frequencyCountMap = new TreeMap<>();

        // Klasik for döngüsü ile sorguları tek tek işle
        for (int i = 0; i < queries.size(); i++) {
            int queryType = queries.get(i).get(0);
            int value = queries.get(i).get(1);

            if (queryType == 1) {
                // --- EKLEME İŞLEMİ (Insert) ---
                int currentFreq = elementFrequencyMap.getOrDefault(value, 0);
                
                // Eski frekansın count değerini bir azalt (Eğer varsa)
                if (currentFreq > 0) {
                    int count = frequencyCountMap.get(currentFreq);
                    if (count == 1) {
                        frequencyCountMap.remove(currentFreq);
                    } else {
                        frequencyCountMap.put(currentFreq, count - 1);
                    }
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
                    int count = frequencyCountMap.get(currentFreq);
                    if (count == 1) {
                        frequencyCountMap.remove(currentFreq);
                    } else {
                        frequencyCountMap.put(currentFreq, count - 1);
                    }
                    
                    if (currentFreq > 1) {
                        int newFreq = currentFreq - 1;
                        elementFrequencyMap.put(value, newFreq);
                        frequencyCountMap.put(newFreq, frequencyCountMap.getOrDefault(newFreq, 0) + 1);
                    } else {
                        elementFrequencyMap.remove(value);
                    }
                }

            } else if (queryType == 3) {
                // --- KONTROL İŞLEMİ (Check Frequency) ---
                // Bu soruda value doğrudan aranan frekans değerini temsil eder.
                // TreeMap veya doğrudan containsKey ile o frekansın var olup olmadığı kontrol edilir.
                if (frequencyCountMap.containsKey(value) && frequencyCountMap.get(value) > 0) {
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
