import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int answer=Integer.MIN_VALUE, n;
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dy = new int[n];
		dy[0] = arr[0];
		
		for(int i=0; i<n; i++) {
			if(i!=0) {
				dy[i] = Math.max(arr[i], dy[i-1]+arr[i]);
			}
			answer = Math.max(answer, dy[i]);
		}
		
		System.out.println(answer);
	}
	
}

