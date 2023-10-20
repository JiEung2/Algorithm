class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] weapons = new int[number];
        
        for(int i=2; i<= number; i++){
            int cnt = 0;
            for(int j=1; j*j<=i; j++){
                if(i % j == 0) {
                    if(j*j == i)cnt++;
                    else  cnt+=2;
                }
            }
            if(cnt > limit) cnt = power;
            answer += cnt;
        }
        answer += 1;
        return answer;
    }
}