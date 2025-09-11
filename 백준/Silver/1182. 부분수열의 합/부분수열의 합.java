import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0, 0);
        System.out.println(result);
    }

    public static void solution(int index, int sum, int size) {
        if (index == arr.length) {
            if (sum == s && size > 0) {
                result++;
            }
            return;
        }

        solution(index + 1, sum, size);
        solution(index + 1, sum + arr[index], size + 1);
    }
}
