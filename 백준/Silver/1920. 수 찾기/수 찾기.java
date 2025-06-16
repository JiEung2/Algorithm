
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int r = A.length - 1;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());

            int result = solution(r, A, number);
            sb.append(result);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int solution(int r, int[] A, int number) {
        int lp = 0;
        int rp = r;

        while (lp <= rp) {
            int middle = (lp + rp) / 2;
            if (A[middle] == number) {
                return 1;
            } else if (A[middle] > number) {
                rp = middle - 1;
            } else {
                lp = middle + 1;
            }
        }
        return 0;
    }
}
