import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int good;
    static int sad;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[][] area = new char[n][n];
        int[][] check = new int[n][n];
        int[][] sadCheck = new int[n][n];

        good = 0;
        sad = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            area[i] =line.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j, area, check);
                sadBfs(i, j, area, sadCheck);
            }
        }

        System.out.println(good + " " + sad);

    }

    public static void bfs(int sx, int sy, char[][] area, int[][] check) {
        Queue<int[]> q = new LinkedList<>();

        if (check[sx][sy] == 0) {
            q.add(new int[]{sx, sy});
            check[sx][sy] = 1;
            good += 1;
        }

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && area[nx][ny] == area[x][y] && check[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    check[nx][ny] = 1;
                }
            }
        }

    }

    public static void sadBfs(int sx, int sy, char[][] area, int[][] check) {
        Queue<int[]> q = new LinkedList<>();

        if (check[sx][sy] == 0) {
            q.add(new int[]{sx, sy});
            check[sx][sy] = 1;
            sad += 1;
        }

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && isSame(area[nx][ny], area[x][y]) && check[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    check[nx][ny] = 1;

                }
            }
        }

    }

    public static boolean isSame(char a, char b) {
        if (a == b) return true;
        else if((a == 'G' && b == 'R') || (a == 'R' && b =='G')) return true;

        return false;
    }
}
