import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[] dz = {0, 0, -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[h][n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs(map, q);

        int result = extractResult(map);

        System.out.println(result);
    }

    private static int extractResult(int[][][] map) {
        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        return -1;
                    }
                    max = Math.max(max, map[i][j][k]);
                }
            }
        }
        return max - 1;
    }

    public static void bfs(int[][][] map, Queue<int[]> q) {

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            int z = point[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < n && nz >= 0 && nz < m) {
                    if (map[nx][ny][nz] == 0) {
                        map[nx][ny][nz] = map[x][y][z] + 1;
                        q.add(new int[] {nx, ny, nz});
                    }
                }
            }
        }

    }
}
