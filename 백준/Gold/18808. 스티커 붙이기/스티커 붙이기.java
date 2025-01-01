import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] notebook;
    static List<int[][]> stickers;
    static int n, m, K, result;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        notebook = new int[n][m];
        check = new boolean[n][m];
        stickers = new ArrayList<>();

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int sn = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[sn][sm];

            for (int i = 0; i < sn; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < sm; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(sticker);
        }

        search(0, 0);
        System.out.println(result);
    }

    public static void search(int k, int cnt) {
        if (k == K) {
            result = Math.max(cnt, result);
            return;
        }
        int[][] sticker = stickers.get(k);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sticker.length > n - i || sticker[0].length > m-j) continue;
                int tmp = attach(i, j, sticker);
                if(tmp == 0) continue;
                search(k + 1, cnt + tmp);
                return;
            }
        }

        for(int z = 0; z < 3; z++){
            sticker = rotate(sticker);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if (sticker.length > n - i || sticker[0].length > m-j) continue;
                    int tmp = attach(i, j, sticker);
                    if(tmp == 0) continue;
                    search(k + 1, cnt + tmp);
                    return;
                }
            }
        }
        search(k + 1, cnt);
    }

    public static int attach(int x, int y, int[][] sticker) {
        int result = 0;
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (sticker[i][j] == 1) {
                    if (check[i + x][j + y]) {
                        return 0;
                    }
                    result++;
                }
            }
        }
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (sticker[i][j] == 1) {
                    check[i + x][j + y] = true;
                }
            }
        }

        return result;
    }

    public static int[][] rotate(int[][] sticker) {
        int[][] tmp = new int[sticker[0].length][sticker.length];

        for(int i = 0; i < sticker.length; i++){
            for(int j = 0; j < sticker[i].length; j++){
                tmp[j][sticker.length-1-i] = sticker[i][j];
            }
        }
        return tmp;
    }
}
