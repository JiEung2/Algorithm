import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int[] colorPaper = {0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int n = 10;

        paper = new int[n][n];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int cnt) {
        if (x == 10) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (answer <= cnt) {
            return;
        }

        if (y > 9) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if (paper[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (colorPaper[i] > 0 && isAttach(x, y, i)) {
                    colorPaper[i]--;
                    attach(x, y, i, 0);
                    dfs(x, y + 1, cnt + 1);
                    colorPaper[i]++;
                    attach(x, y, i, 1);
                }
            }
        } else {
            dfs(x, y + 1, cnt);
        }
    }

    public static void attach(int x, int y, int size, int flag) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                paper[x + i][y + j] = flag;
            }
        }
    }

    public static boolean isAttach(int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (x + i < 0 || x + i >= 10 || y + j < 0 || y + j >= 10) {
                    return false;
                }
                if (paper[x + i][y + j] != 1) return false;
            }
        }
        return true;
    }

}
