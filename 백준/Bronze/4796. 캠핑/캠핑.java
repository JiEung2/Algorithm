import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while(true) {
			index++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			if(L == 0 && P == 0 && V == 0) break;
			int sum = 0;
			
			sum += L * (V / P) + Math.min((V % P), L);
			sb.append("Case " + index + ": " + sum + "\n");
		}
		System.out.println(sb);
	}

}
