class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        for(int i = 1; i < total; i++) {
            if(total % i == 0) {
                int num1 = i;
                int num2 = total / i ;
                int big = Math.max(num1, num2);
                int small = Math.min(num1, num2);
                
                if((big - 2) * (small - 2) == yellow) {
                    answer[0] = big;
                    answer[1] = small;
                    break;
                }
            }
        }
        
        return answer;
    }
}