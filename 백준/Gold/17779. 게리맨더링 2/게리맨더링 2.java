import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int total;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                for(int d1 = 1; d1 < n; d1++){
                    for(int d2 = 1; d2 < n; d2++){
                        if (x + d1 + d2 >= n) continue;
                        if (y - d1 < 0 || y + d2 >= n) continue;
                        solution(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static void solution(int x, int y, int d1, int d2){
        boolean[][] boundary = new boolean[n][n];
        int[] sum = new int[5];

        for(int i = 0; i <= d1; i++){
            boundary[x+i][y-i] = true;
            boundary[x+d2+i][y+d2-i] = true;
        }
        for(int i = 0; i <= d2; i++){
            boundary[x+i][y+i] = true;
            boundary[x+d1+i][y-d1+i] = true;
        }

        for(int i = 0; i < x+d1; i++){
           for(int j = 0; j <= y; j++){
               if(boundary[i][j]) break;
               sum[0] += map[i][j];
           }
        }

        for(int i = 0; i <= x+d2; i++){
            for(int j = n-1; j > y; j--){
                if(boundary[i][j]) break;
                sum[1] += map[i][j];
            }
        }

        for(int i = x + d1; i < n; i++){
            for(int j = 0; j < y-d1+d2; j++){
                if(boundary[i][j]) break;
                sum[2] += map[i][j];
            }
        }

        for(int i = x + d2 + 1; i < n; i++){
            for(int j = n-1; j >= y-d1+d2; j--){
                if(boundary[i][j]) break;
                sum[3] += map[i][j];
            }
        }

        sum[4] = total - sum[0] - sum[1] - sum[2] - sum[3];

        Arrays.sort(sum);
        result = Math.min(result, sum[4] - sum[0]);
    }}