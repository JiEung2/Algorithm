import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] fireCheck;
    public static int[][] personCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        fireCheck = new int[n][m];
        personCheck = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] tmp = line.toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp[j];
                fireCheck[i][j] = Integer.MAX_VALUE;
                personCheck[i][j] = Integer.MAX_VALUE;
                if (tmp[j] == '#') {
                    fireCheck[i][j] = -1;
                    personCheck[i][j] = -1;
                }
            }
        }

        fireBfs(map, n, m);
        personBfs(map, n, m);

//        System.out.println("------------");
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                System.out.print(fireCheck[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("=============");
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                System.out.print(personCheck[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("------------");
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if ((fireCheck[i][j] == 0 || personCheck[i][j] < fireCheck[i][j]) && personCheck[i][j] < result) {
                        result = personCheck[i][j];
                    }
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(result);
        }
    }

    public static void fireBfs(char[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'F' && fireCheck[i][j] == Integer.MAX_VALUE) {
                    q.add(new int[]{i, j});
                    fireCheck[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && (map[nx][ny] == '.' || map[nx][ny] == 'J') && fireCheck[nx][ny] == Integer.MAX_VALUE) {
                    q.add(new int[]{nx, ny});
                    fireCheck[nx][ny] = fireCheck[point[0]][point[1]] + 1;
                }
            }
        }
    }

    public static void personBfs(char[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'J' && personCheck[i][j] == Integer.MAX_VALUE) {
                    q.add(new int[]{i, j});
                    personCheck[i][j] = 1;
                    break;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '.' && personCheck[nx][ny] == Integer.MAX_VALUE) {
                    q.add(new int[]{nx, ny});
                    personCheck[nx][ny] = personCheck[point[0]][point[1]] + 1;
                }
            }
        }
    }
}
