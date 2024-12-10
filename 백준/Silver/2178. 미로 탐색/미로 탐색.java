import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        System.out.println(solution(map, n, m));
    }

    public static int solution(int[][] map, int n, int m) {
        int[][] check = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        check[0][0] = 1;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && check[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    check[nx][ny] = check[point[0]][point[1]] + 1;
                }
            }
        }

        return check[n - 1][m - 1];
    }
}
