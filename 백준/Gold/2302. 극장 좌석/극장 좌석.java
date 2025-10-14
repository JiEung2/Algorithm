import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
        }
        else{
            int[] arr = new int[n + 1];

            arr[1] = 1;
            arr[2] = 2;

            for (int i = 3; i < n + 1; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }

            int[] vip = new int[m];

            int result = 1;

            for (int i = 0; i < m; i++) {
                vip[i] = Integer.parseInt(br.readLine());
                int tmp = 0;
                if (i == 0) {
                    tmp = vip[i] - 1;
                }else{
                    tmp = vip[i] - vip[i - 1] - 1;
                }

                if (tmp < 1) tmp = 1;
//            System.out.println("i = " + i + "tmp = " + tmp);
                result *= arr[tmp];
            }

            if (m > 0) {
                int last = n - vip[m - 1];
                if (last < 1) last = 1;
                result *= arr[last];
            } else{
                result *= arr[n];
            }
            System.out.println(result);
        }
    }
}
