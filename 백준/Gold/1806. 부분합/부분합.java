import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lp = 0;
        int rp = 0;
        int result = Integer.MAX_VALUE;

        int sum = arr[0];

        while (true) {
            if (sum < m) {
                rp++;
                if (rp == n) break;
                sum += arr[rp];
            }else{
                result = Math.min(result, rp - lp + 1);
                sum -= arr[lp];
                lp++;
                if (lp == n) break;
            }

            if (lp > rp) {
                rp = lp;
                sum = arr[lp];
            }
        }

        if (result == Integer.MAX_VALUE) result = 0;
        System.out.println(result);
    }
}
