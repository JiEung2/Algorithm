import java.util.*;
import java.io.*;

class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Main {
	static int[][] map;
	static int n;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Point> q;
	static boolean check[][];
	public void BFS(int x, int y, int h) {
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp.x+dx[i];
				int ny = tmp.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && !check[nx][ny] && map[nx][ny]>h) {
					check[nx][ny] = true;
					q.offer(new Point(nx,ny));
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int maxh = 0, max=0;
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>maxh) maxh = map[i][j];
			}
		}
		q = new LinkedList<>();
		
		for(int h=0; h<maxh; h++) {
			check = new boolean[n][n];
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!check[i][j] && map[i][j]>h) {
						q.offer(new Point(i,j));
						T.BFS(i,j,h);
						cnt++;
					}	
				}
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	
	}
}
