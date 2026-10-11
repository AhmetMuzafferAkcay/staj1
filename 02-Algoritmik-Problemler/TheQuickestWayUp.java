import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class TheQuickestWayUp {

    static class Cell {
        int index;
        int distance;

        public Cell(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        // Tahtadaki 100 kare için geçişleri tutacak dizi (merdiven ve yılanlar)
        int[] board = new int[101];
        
        // Başlangıçta her kare kendi numarasını temsil eder
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        // Merdivenlerin başlangıç ve bitiş noktalarını işle
        for (int i = 0; i < ladders.size(); i++) {
            int start = ladders.get(i).get(0);
            int end = ladders.get(i).get(1);
            board[start] = end;
        }

        // Yılanların başlangıç ve bitiş noktalarını işle
        for (int i = 0; i < snakes.size(); i++) {
            int start = snakes.get(i).get(0);
            int end = snakes.get(i).get(1);
            board[start] = end;
        }

        // BFS için ziyaret edilenler dizisi ve kuyruk yapısı
        boolean[] visited = new boolean[101];
        Queue<Cell> queue = new LinkedList<>();

        // 1. kareden 0 hamle ile başla
        queue.add(new Cell(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // Eğer 100. kareye ulaşıldıysa toplam hamle sayısını dön
            if (current.index == 100) {
                return current.distance;
            }

            // Zar atma simülasyonu: 1'den 6'ya kadar ilerle
            for (int dice = 1; dice <= 6; dice++) {
                int nextCell = current.index + dice;

                if (nextCell <= 100) {
                    // Merdiven veya yılan varsa, varış noktasına git
                    int destination = board[nextCell];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.add(new Cell(destination, current.distance + 1));
                    }
                }
            }
        }

        // 100. kareye ulaşmak imkansızsa -1 dön
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Test case sayısı

        for (int i = 0; i < t; i++) {
            // Merdivenleri al
            int numLadders = scanner.nextInt();
            List<List<Integer>> ladders = new ArrayList<>();
            for (int j = 0; j < numLadders; j++) {
                List<Integer> ladder = new ArrayList<>();
                ladder.add(scanner.nextInt());
                ladder.add(scanner.nextInt());
                ladders.add(ladder);
            }

            // Yılanları al
            int numSnakes = scanner.nextInt();
            List<List<Integer>> snakes = new ArrayList<>();
            for (int j = 0; j < numSnakes; j++) {
                List<List<Integer>> snake = new ArrayList<>();
                snake.add(scanner.nextInt());
                snake.add(scanner.nextInt());
                snakes.add(snake);
            }

            int result = quickestWayUp(ladders, snakes);
            System.out.println(result);
        }

        scanner.close();
    }
}
