import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExamples {

    public static void main(String[] args) {
        // 1. Eklenme Sırasını Koruyan LinkedHashMap Örneği (Insertion-Order)
        // Başlangıç kapasitesi, yük faktörü ve false (eklenme sırası modu) ile tanımlanır.
        LinkedHashMap<String, Integer> insertionOrderMap = new LinkedHashMap<>(16, 0.75f, false);

        insertionOrderMap.put("Elma", 10);
        insertionOrderMap.put("Armut", 25);
        insertionOrderMap.put("Muz", 15);
        insertionOrderMap.put("Çilek", 40);

        System.out.println("--- 1. Eklenme Sırası (Insertion Order) ---");
        // Klasik for-each veya entrySet gezinimi ile yazdıralım
        for (Map.Entry<String, Integer> entry : insertionOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        // 2. Erişim Sırasını Koruyan LinkedHashMap Örneği (Access-Order / LRU Mantığı)
        // Üçüncü parametre true yapıldığında, üzerine yazılan veya okunan (get edilen) eleman en sona taşınır.
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);

        accessOrderMap.put("Java", 1);
        accessOrderMap.put("Python", 2);
        accessOrderMap.put("C++", 3);

        // "Java" elemanına erişim sağlayalım (get işlemi)
        accessOrderMap.get("Java");

        System.out.println("\n--- 2. Erişim Sırası (Access Order - 'Java' okunduktan sonra) ---");
        for (Map.Entry<String, Integer> entry : accessOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
