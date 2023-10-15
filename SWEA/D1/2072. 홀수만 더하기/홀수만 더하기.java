import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int i= 0; i < T; i++)
		{
			int sum = 0;
            for(int j=0; j<10; j++){
                int n = sc.nextInt();
                if(n%2 != 0) sum += n;
            }
			System.out.println("#"+(i+1)+" "+sum);
            sum = 0;
		}
	}
}