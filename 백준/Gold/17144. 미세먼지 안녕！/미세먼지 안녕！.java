import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int[][] room;
	static int airPurifier = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) airPurifier = i;
			}
		}
		
		int time = 0;
		
		int[] x = {-1,0,1,0};
		int[] y = {0,1,0,-1};
		
		
		
		
		while(time < T) {
			Queue<Dust> queue = new LinkedList<>();
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(room[i][j] > 0) {
						queue.add(new Dust(i, j, room[i][j]));
					}
				}
			}
			
			while(!queue.isEmpty()) {
				Dust tmpDust = queue.poll();
				if(tmpDust.w < 5) continue;
				int sum = 0;
				for(int k=0; k<4; k++) {
					int tmpX = tmpDust.x + x[k];
					int tmpY = tmpDust.y + y[k];
					if(tmpX >= 0 && tmpX < R && tmpY >= 0 && tmpY < C && room[tmpX][tmpY] != -1) {
						room[tmpX][tmpY] += tmpDust.w / 5;
						sum += tmpDust.w / 5;
					}
				}
				room[tmpDust.x][tmpDust.y] -= sum;
			}
			operate();
			time++;
		}
		
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(room[i][j] > 0) result += room[i][j];
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void operate() {
		int top = airPurifier - 1;
		int down = airPurifier;
		
		for(int i= top - 1; i > 0; i--) {
			room[i][0] = room[i-1][0];
		}
		
		for(int i= 0; i<C-1; i++) {
			room[0][i] = room[0][i+1];
		}
		
		for(int i=0; i<top; i++) {
			room[i][C-1] = room[i+1][C-1];
		}
		
		for(int i=C-1; i>1; i--) {
			room[top][i] = room[top][i-1];
		}
		
		room[top][1] = 0;
		
		for(int i=down+1; i<R-1; i++) {
			room[i][0] = room[i+1][0];
		}
		
		for(int i= 0; i<C-1; i++) {
			room[R-1][i] = room[R-1][i+1];
		}
		
		for(int i=R-1; i>down; i--) {
			room[i][C-1] = room[i-1][C-1];
		}
		
		for(int i=C-1; i>1; i--) {
			room[down][i] = room[down][i-1];
		}
		room[down][1] = 0;
	}
	
	static class Dust{
		int x, y, w;
		
		public Dust(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

}
