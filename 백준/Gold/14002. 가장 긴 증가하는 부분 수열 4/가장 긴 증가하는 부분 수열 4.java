import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt = Math.max(cnt, dp[i]);
        }
        int result = cnt;

        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == cnt) {
                s.push(arr[i]);
                cnt--;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!s.isEmpty()) {
            sb.append(s.pop() + " ");
        }

        System.out.println(result);
        System.out.println(sb.toString());
    }
}
