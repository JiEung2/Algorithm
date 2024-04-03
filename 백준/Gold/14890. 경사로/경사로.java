import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, L, result;
    static int[][] map;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            if (calRow(i)) result++;
            if (calCol(i)) result++;
        }

        System.out.println(result);
    }

    public static boolean calRow(int row) {
        boolean[] check = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int h = map[row][i] - map[row][i + 1];

            if (h > 1 || h < -1) return false;
            else if (h == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || check[i - j]) return false;
                    if (map[row][i] != map[row][i - j]) return false;
                    check[i - j] = true;
                }
            } else if (h == 1) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= n || check[i + j]) return false;
                    if (map[row][i] - 1 != map[row][i + j]) return false;
                    check[i + j] = true;
                }
            }
        }
        return true;
    }

    public static boolean calCol(int col) {
        boolean[] check = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int h = map[i][col] - map[i + 1][col];

            if (h > 1 || h < -1) return false;
            else if (h == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || check[i - j]) return false;
                    if (map[i][col] != map[i - j][col]) return false;
                    check[i - j] = true;
                }
            } else if (h == 1) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= n || check[i + j]) return false;
                    if (map[i][col] - 1 != map[i + j][col]) return false;
                    check[i + j] = true;
                }
            }
        }
        return true;
    }
}