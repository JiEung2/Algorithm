import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int result = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0) {
                    solve(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void solve(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        map[x][y] = 2;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int tx = point[0];
            int ty = point[1];

            for(int i = 0; i < 4; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx < 0) nx = N - 1;
                if(ny < 0) ny = M - 1;
                if(nx > N-1) nx = 0;
                if(ny > M-1) ny = 0;

                if(map[nx][ny] == 0){
                    map[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
