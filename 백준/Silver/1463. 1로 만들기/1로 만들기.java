import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(T.solution(0, n));
    }

    public int solution(int L, int n){
        if(n < 2) return L;
        return Math.min((solution(L+1+(n%2),n/2)),(solution(L+1+(n%3),n/3)));
    }
}
