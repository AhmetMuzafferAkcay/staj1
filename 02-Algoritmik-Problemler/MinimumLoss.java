import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class MinimumLoss {

    public static long minimumLoss(List<Long> price) {
        long minLoss = Long.MAX_VALUE;
        TreeSet<Long> priceSet = new TreeSet<>();

        // Klasik for döngüsü ile fiyatları sırasıyla incele
        for (int j = 0; j < price.size(); j++) {
            long currentPrice = price.get(j);
            
            // TreeSet içerisinden currentPrice değerinden büyük olan en küçük fiyatı bul 
            // (Bu geçmişteki bir alış fiyatını temsil eder: buy > sell)
            Long higherPrice = priceSet.higher(currentPrice);

            if (higherPrice != null) {
                long loss = higherPrice - currentPrice;
                if (loss < minLoss) {
                    minLoss = loss;
                }
            }

            // Mevcut fiyatı set'e ekle ki sonraki yıllar için alış fiyatı olabilsin
            priceSet.add(currentPrice);
        }

        return minLoss;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Long> price = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            price.add(scanner.nextLong());
        }

        scanner.close();

        long result = minimumLoss(price);
        System.out.println(result);
    }
}
