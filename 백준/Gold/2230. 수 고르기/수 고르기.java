import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int result = Integer.MAX_VALUE;

        int left = 0, right = 0;

        while (right < n) {
            int diff = A[right] - A[left];

            if (diff < m) {
                right++;
            }
            else {
                result = Math.min(result, diff);
                left++;

                if (left > right) {
                    right = left;
                }
            }
        }

        System.out.println(result);
    }
}
