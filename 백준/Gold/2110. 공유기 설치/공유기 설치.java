
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1, right = arr[N-1] - arr[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (can(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    public static boolean can(int mid) {
        int before = arr[0];
        int cnt = C - 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] - before >= mid) {
                cnt--;
                before = arr[i];
            }
        }

        if (cnt <= 0) return true;

        return false;
    }
}
