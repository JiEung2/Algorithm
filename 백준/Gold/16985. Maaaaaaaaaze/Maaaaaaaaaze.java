import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n = 5, result;
    static int[][][] map, copy;
    static boolean[][][] visit;
    static int[] order, dir;
    static boolean[] check;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Point {
        int x, y, z, cnt;

        public Point(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[n][n][n];
        check = new boolean[n];
        order = new int[n];
        dir = new int[n];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        select(0);

        if (result >= Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    public static void select(int cnt) {
        if (cnt == 5) {
            copy = new int[n][n][n];
            for (int i = 0; i < n; i++) {
                rotate(0);
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            order[cnt] = i;

            select(cnt + 1);
            check[i] = false;
        }
    }

    public static void rotate(int cnt) {
        if (cnt == 5) {
            for (int i = 0; i < n; i++) {
                int seq = order[i];
                int d = dir[seq];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (d == 0) {
                            copy[i][j][k] = map[seq][j][k];
                        }
                        if (d == 1) {
                            copy[i][k][4 - j] = map[seq][j][k];
                        }
                        if (d == 2) {
                            copy[i][4 - j][4 - k] = map[seq][j][k];
                        }
                        if (d == 3) {
                            copy[i][4 - k][j] = map[seq][j][k];
                        }
                    }
                }
            }
            if (copy[0][0][0] == 1 && copy[4][4][4] == 1) {
                bfs();
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            dir[cnt] = i;
            rotate(cnt + 1);
        }
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        visit = new boolean[n][n][n];
        q.add(new Point(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.x == 4 && point.y == 4 && point.z == 4) {
                result = Math.min(result, point.cnt);
                if (result == 12) {
                    System.out.println(12);
                    System.exit(0);
                }
                break;
            }

            for (int d = 0; d < 6; d++) {
                int nx = point.x + dx[d];
                int ny = point.y + dy[d];
                int nz = point.z + dz[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && nz >= 0 && nz < n && !visit[nx][ny][nz] && copy[nx][ny][nz] == 1) {
                    visit[nx][ny][nz] = true;
                    q.add(new Point(nx, ny, nz, point.cnt + 1));
                }
            }
        }
    }
}
