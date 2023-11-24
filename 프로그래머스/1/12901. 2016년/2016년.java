class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int sum = 0;
        for(int i=0; i<a-1; i++){
            sum += days[i];
        }
        sum += b;
        if(sum % 7 == 1) return "FRI";
        if(sum % 7 == 2) return "SAT";
        if(sum % 7 == 3) return "SUN";
        if(sum % 7 == 4) return "MON";
        if(sum % 7 == 5) return "TUE";
        if(sum % 7 == 6) return "WED";
        if(sum % 7 == 0) return "THU";
        return answer;
    }
}