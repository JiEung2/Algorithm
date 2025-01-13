import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (find(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    static boolean find(int index) {
        int target = arr[index];
        int l = 0, r = n - 1;

        while (l < r) {
            if (l == index) {
                l++;
                continue;
            }
            if (r == index) {
                r--;
                continue;
            }

            int sum = arr[l] + arr[r];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}
