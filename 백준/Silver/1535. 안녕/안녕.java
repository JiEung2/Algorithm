import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] arr2 = new int[n+1];
        int[][] dp = new int[n+1][100];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=99; j++){
                if(arr[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i]]+arr2[i]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[n][99]);
    }
}
