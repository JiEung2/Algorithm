import java.lang.Math;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while(Math.max(a,b) % 2 != 0 || Math.abs(a-b) != 1){
            answer++;
            if(a % 2 == 1) a = a / 2 + 1;
            else a /= 2;
            if(b % 2 == 1) b = b / 2 + 1;
            else b /= 2;
        }
        
        return answer;
    }
}