import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, answer = 0;
    static boolean[] col, diag1, diag2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new boolean[n];
        diag1 = new boolean [2 * n - 1];
        diag2 = new boolean [2 * n - 1];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            int d1 = row + i;
            int d2 = row - i + n - 1;

            if (col[i] || diag1[d1] || diag2[d2]) continue;

            col[i] = diag1[d1] = diag2[d2] = true;
            dfs(row + 1);
            col[i] = diag1[d1] = diag2[d2] = false;

        }

    }
}
