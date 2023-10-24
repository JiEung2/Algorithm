import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lp = 0, rp = people.length-1;
        
        while(lp<=rp){
            if(people[lp] + people[rp] <= limit) lp++;
            answer++;
            rp--;
        }
        
        return answer;
    }
}