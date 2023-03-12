import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		System.out.println(T.solution(n));
	}
	
	public int solution(int n) {
		int answer=0;
		int[] ch = new int[n+1];
		
		for(int i=2; i<=n; i++) {
			if(ch[i]==0) {
				answer++;
				for(int j=i; j<=n; j+=i) {
					ch[j]=1;
				}
			}
			
		}
		
		return answer;
	}
}
