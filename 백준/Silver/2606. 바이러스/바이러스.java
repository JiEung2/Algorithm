import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] check;
    static int cnt = 0;
    static int node = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        check = new int[node + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            arr[node1][node2] = 1;
            arr[node2][node1] = 1;
        }
        DFS(1);
        System.out.println(cnt - 1);
    }

    public static void DFS(int start) {
        check[start] = 1;
        cnt++;
        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && check[i] != 1) {
                DFS(i);
            }
        }
    }
}
