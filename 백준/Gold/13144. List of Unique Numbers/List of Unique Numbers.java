import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        long result = 0;
        int lp = 0;
        Set<Integer> set = new HashSet<>();

        for (int rp = 0; rp < n; rp++) {
            while (set.contains(arr[rp])) {
                set.remove(arr[lp]);
                lp++;
            }

            set.add(arr[rp]);
            result += (rp - lp + 1);
        }
        System.out.println(result);
    }
}
