import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char result = ' ';
        if (n >= 90) {
            result = 'A';
        } else if (n >= 80) {
            result = 'B';
        } else if (n >= 70) {
            result = 'C';
        } else if (n >= 60) {
            result = 'D';
        } else result = 'F';

        System.out.println(result);
    }
}
