import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int left = 0;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (can(mid)) {
                left = mid + 1;
            } else right = mid - 1;
        }

        System.out.println(right);
    }

    public static boolean can(int height) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] - height > 0) {
                sum += arr[i] - height;
            }
        }
        if (sum >= m) return true;
        return false;
    }
}
