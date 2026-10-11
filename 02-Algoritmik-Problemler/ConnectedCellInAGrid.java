import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ConnectedCellInAGrid {

    // 8 yön (yatay, dikey ve çapraz komşular)
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int connectedCell(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        boolean[][] visited = new boolean[n][m];
        int maxRegion = 0;

        // Matrisin her hücresini klasik for döngüsü ile gezin
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Eğer hücre 1 ise ve daha önce ziyaret edilmediyse yeni bir bölge başlat
                if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                    int size = dfs(matrix, visited, i, j, n, m);
                    if (size > maxRegion) {
                        maxRegion = size;
                    }
                }
            }
        }
        return maxRegion;
    }

    private static int dfs(List<List<Integer>> matrix, boolean[][] visited, int r, int c, int n, int m) {
        visited[r][c] = true;
        int count = 1;

        // 8 komşu yönü kontrol et
        for (int i = 0; i < 8; i++) {
            int newRow = r + rowDir[i];
            int newCol = c + colDir[i];

            if (isValid(newRow, newCol, n, m, matrix, visited)) {
                count += dfs(matrix, visited, newRow, newCol, n, m);
            }
        }
        return count;
    }

    private static boolean isValid(int r, int c, int n, int m, List<List<Integer>> matrix, boolean[][] visited) {
        // Matris sınırları içinde mi, değeri 1 mi ve daha önce ziyaret edildi mi?
        return (r >= 0 && r < n && c >= 0 && c < m && matrix.get(r).get(c) == 1 && !visited[r][c]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }

        scanner.close();

        int result = connectedCell(matrix);
        System.out.println(result);
    }
}
