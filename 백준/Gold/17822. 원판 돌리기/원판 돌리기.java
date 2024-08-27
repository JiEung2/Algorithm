import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static List<Integer>[] circles;
    static boolean[][] checked ;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        checked = new boolean[N][M];
        circles = new ArrayList[N+1];

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            circles[i] = new ArrayList<>();
            for(int j = 0; j < M; j++){
                circles[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
            flag = false;
            for(int j = 1; j <= N; j++){
                for(int z = 0; z < M; z++){
                    if (circles[j].get(z) != 0) {
                        dfs(j, z, circles[j].get(z));
                    }
                }
            }
            if (!flag) {
                cal();
            }
        }

        System.out.println(sum());
    }

    public static void rotate(int x, int d, int k) {
        for(int j = x; j <= N; j+=x){
            if (d == 0) {
                for(int i = 0; i < k; i++){
                    circles[j].add(0, circles[j].remove(M - 1));
                }
            }
            else{
                for(int i = 0; i < k; i++){
                    int tmp = circles[j].remove(0);
                    circles[j].add(tmp);
                }
            }

        }

    }

    public static void dfs(int x, int y, int value) {
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(ny == M) ny = 0;
            if(ny == -1) ny = M-1;

            if (nx >= 1 && nx <= N && circles[nx].get(ny) == value && circles[nx].get(ny) != 0) {
                circles[nx].set(ny, 0);
                flag = true;
                dfs(nx, ny, value);
            }
        }
    }

    public static void cal() {
        int sum = 0;
        int cnt = 0;
        for(int i = 1; i < N+1; i++){
            for(int j = 0; j < M; j++){
                if (circles[i].get(j) != 0) {
                    sum += circles[i].get(j);
                    cnt++;
                }
            }
        }
        if (cnt == 0) {
            return;
        }
        double average = (double) sum / cnt;
        for(int i = 1; i < N+1; i++){
            for(int j = 0; j < M; j++){
                if (circles[i].get(j) != 0) {
                    if (circles[i].get(j) > average) {
                        circles[i].set(j, circles[i].get(j) - 1);
                    }
                    else if(circles[i].get(j) < average){
                        circles[i].set(j, circles[i].get(j) + 1);
                    }
                }
            }
        }
    }

    public static int sum (){
        int sum = 0;
        for(int i = 1; i < N+1; i++){
            for(int j = 0; j < M; j++){
                sum += circles[i].get(j);
            }
        }

        return sum;
    }
}
