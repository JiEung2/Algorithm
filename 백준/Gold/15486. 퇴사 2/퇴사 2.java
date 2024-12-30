import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] T = new int[n+1];
        int[] P = new int[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++){
            dp[i] = Math.max(dp[i - 1], dp[i]);

            int day = i + T[i] - 1;
            if (day > n) {
                continue;
            }
            dp[day] = Math.max(dp[i-1] + P[i], dp[day]);
        }

        int result = 0;

        for(int i = 1; i <= n; i++){
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
