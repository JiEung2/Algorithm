class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=yellow; i>=1; i--){
            if(yellow % i == 0){
                int tmp = yellow / i;
                if(((i + 2) * 2 + tmp * 2) == brown) {
                    answer[0] = i+2;
                    answer[1] = tmp+2;
                    break;
                }
            }
        }
        return answer;
    }
}