import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Shark{
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static int R, C, M;
    static Shark[][] map;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static List<Shark> sharkList;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = new Shark(r - 1, c - 1, s, d, z);
        }

        solve();
        System.out.println(result);

    }

    public static void solve(){
        for(int i = 0; i < C; i++){
            for(int j = 0; j < R; j++){
                if (!(map[j][i] == null)){
                    result += map[j][i].z;
                    map[j][i] = null;
                    break;
                }
            }
            move();
        }
    }

    public static void move(){
        sharkList = new ArrayList<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if (map[i][j] == null) continue;
                sharkList.add(map[i][j]);
            }
        }
        map = new Shark[R][C];

        for(int i = 0; i < sharkList.size(); i++){
            Shark s = sharkList.get(i);
            int dis = 0;
            int x = s.r;
            int y=  s.c;
            while (dis++ < s.s) {
                int nx = x + dx[s.d];
                int ny = y + dy[s.d];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C){
                    x = nx;
                    y = ny;
                }
                else{
                    if (s.d == 1 || s.d == 3) {
                        s.d += 1;
                    }
                    else{
                        s.d -= 1;
                    }
                    x += dx[s.d];
                    y += dy[s.d];
                }
            }
            s.r = x;
            s.c = y;
        }

        for(int i = 0; i < sharkList.size(); i++){
            Shark s = sharkList.get(i);
            if(map[s.r][s.c] == null) map[s.r][s.c] = s;
            else{
                if(map[s.r][s.c].z < s.z) map[s.r][s.c] = s;
            }
        }
    }
}
