import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n, m;
	static int[][] map;
	static int cnt, wallCnt, result;
	static Queue<Point> q = new LinkedList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		result = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) wallCnt++;
			}
		}
		wallCnt += 3;
		makeWall(0);
		
		System.out.println(result);

	}
	
	public static void makeWall(int L) {
		if(L == 3) {
			check();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(L + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void check() {
		int[][] visited = new int[n][m];
		cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 2) q.add(new Point(i,j));
			}
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			cnt++;
			visited[x][y] = 1;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && visited[nx][ny]==0) {
					visited[nx][ny] = 1;
					q.add(new Point(nx, ny));
				}
			}
		}
		
		result = Math.max(result, (n * m - cnt - wallCnt));
	}

}
