import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[t + 1];

        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[3][t + 1][w + 2];

        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= w + 1; j++) {
                if (arr[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
                } else {
                    if (i == 1 && j == 1) continue;
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]) + 1;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= w + 1; i++) {
            result = Math.max(result, Math.max(dp[1][t][i], dp[2][t][i]));
        }

        System.out.println(result);
    }
}
