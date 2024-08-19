import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static List<Point> virusList = new ArrayList<>();
    static int emptyCount;
    static Point[] selected;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;
        int time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        selected = new Point[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virusList.add(new Point(i, j, 0));
                else if (map[i][j] == 0) {
                    emptyCount++;
                }
            }
        }

        if(emptyCount == 0) {
            System.out.println(0);
        }
        else{
            selectVirus(0, 0);
            if (result == Integer.MAX_VALUE) {
                result = -1;
            }
            System.out.println(result);
        }
    }

    static void selectVirus(int now, int count){
        if(count == m) {
            spreadVirus(emptyCount);
            return;
        }
        else{
            for(int i = now; i < virusList.size(); i++){
                selected[count] = virusList.get(i);
                selectVirus(i+1, count+1);
            }
        }
    }
    static void spreadVirus(int emptyCount) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] checked = new boolean[n][n];

        for(int i = 0; i < m; i++){
            q.add(selected[i]);
            checked[selected[i].x][selected[i].y] = true;
        }

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !checked[nx][ny] && map[nx][ny] != 1){
                    checked[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        emptyCount--;
                    }

                    if(emptyCount == 0){
                        result = Math.min(result, p.time + 1);
                        return;
                    }

                    q.add(new Point(nx, ny, p.time + 1));

                }
            }
        }

    }



}
