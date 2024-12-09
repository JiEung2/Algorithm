import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0, m = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = bfs(map, n, m);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] bfs(int[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[n][m];

        int cnt = 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (map[i][j] == 1 && !check[i][j]) {
                    q.add(new int[]{i, j});
                    check[i][j] = true;

                    cnt++;
                    int size = 1;

                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();
                        int x = tmp[0];
                        int y = tmp[1];

                        for(int z = 0 ; z < 4; z++){
                            int nx = x + dx[z];
                            int ny = y + dy[z];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !check[nx][ny]) {
                                size++;
                                q.add(new int[]{nx, ny});
                                check[nx][ny] = true;
                            }
                        }
                    }

                    result = Math.max(result, size);
                }
            }
        }
        return new int[] {cnt, result};
    }
}
