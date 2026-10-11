import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        
        // List boyutuna göre klasik for döngüsü
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            
            // Not 38'den küçükse yuvarlama yapılmaz, doğrudan eklenir
            if (grade < 38) {
                roundedGrades.add(grade);
            } else {
                // Sonraki 5'in katını bulmak için kalan hesaplanır
                int remainder = grade % 5;
                if (remainder >= 3) {
                    roundedGrades.add(grade + (5 - remainder));
                } else {
                    roundedGrades.add(grade);
                }
            }
        }
        
        return roundedGrades;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> grades = new ArrayList<>();

        // Girdileri döngü ile al
        for (int i = 0; i < n; i++) {
            grades.add(scanner.nextInt());
        }

        scanner.close();

        List<Integer> result = gradingStudents(grades);

        // Sonuçları yazdır
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
