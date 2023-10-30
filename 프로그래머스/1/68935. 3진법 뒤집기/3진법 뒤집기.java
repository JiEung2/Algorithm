
class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmpNum = "";
        while(n>0){
            tmpNum += Integer.toString(n%3);
            n /= 3;
        }
        Long number = Long.parseLong(tmpNum);
        int index = 0;
        while(number>0){
            Long tmp = number%10;
            answer += (Math.pow(3, index) * tmp);
            index++;
            number /= 10;
        }
        
        return answer;
    }
}