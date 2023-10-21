class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int sum = 0;
        
        while(n>=a){
            int tmp = n % a;
            answer += n / a * b;
            n = n / a * b;
            n += tmp;
        }
        
        // answer += sum / a;
        
        return answer;
    }
}