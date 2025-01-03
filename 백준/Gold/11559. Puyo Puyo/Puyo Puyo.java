import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n = 12, m = 6, result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] check;
    static List<Character> alphabet;
    static boolean[][] totalCheck;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.x, o2.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (true) {
            if (search()) {
                break;
            }
            result++;
        }

//        for(int i = 0; i < n; i ++){
//            for(int j = 0; j < m; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(result);
    }

    static boolean search() {
//        for(int i = 0; i < n; i ++){
//            for(int j = 0; j < m; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();

        totalCheck = new boolean[n][m];
        PriorityQueue<Point> removeList = new PriorityQueue<>(new PointComparator());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '.' && !totalCheck[i][j]) {
                    removeList.addAll(bfs(i, j));
                }
            }
        }
        if (!removeList.isEmpty()) {
            remove(removeList);
            return false;
        }

        return true;
    }

    static void remove(PriorityQueue<Point> removeList) {
        while(!removeList.isEmpty()){
            Point point = removeList.poll();
            move(point.x, point.y);
        }
    }

    static void move(int x, int y) {
        for (int i = x; i > 0; i--) {
            map[i][y] = map[i - 1][y];
        }
        map[0][y] = '.';
    }

    static PriorityQueue<Point> bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        check = new boolean[n][m];
        check[x][y] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            cnt++;
            int[] point = q.poll();
            int tx = point[0];
            int ty = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == map[tx][ty] && !check[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    check[nx][ny] = true;
                }
            }
        }

        PriorityQueue<Point> points = new PriorityQueue<>(new PointComparator());

        if (cnt >= 4) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (check[i][j]) {
                        totalCheck[i][j] = true;
                        points.add(new Point(i, j));
                    }
                }
            }
        }

        return points;
    }

}
