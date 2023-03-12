import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		}
		for(int x : T.solution(arr, n)) {
			System.out.print(x+" ");
		}
		
	}
	public ArrayList<Integer> solution(int[] arr, int n) {
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(check(arr[i])) answer.add(arr[i]);
		}
		
		return answer;
	}
	public boolean check(int n) {
		if(n==1) return false;
		else {
			for(int i=2; i<=n/2; i++) {
				if(n%i==0) return false;
			}
		}
		return true;
	}
}
