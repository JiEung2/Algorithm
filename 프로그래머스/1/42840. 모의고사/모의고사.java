import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int one[] = new int[] {1,2,3,4,5};
        int two[] = new int[] {2,1,2,3,2,4,2,5};
        int three[] = new int[] {3,3,1,1,2,2,4,4,5,5};
        
        int f = 0, s = 0, t = 0;
        for(int i = 0 ; i < answers.length; i++) {
            if(one[i % one.length] == answers[i]) f++;
            if(two[i % two.length] == answers[i]) s++;
            if(three[i % three.length] == answers[i]) t++;
        }
        
        int max = Math.max(Math.max(f, s), t);
        if(f == max) answer.add(1);
        if(s == max) answer.add(2);
        if(t == max) answer.add(3);
        
        Collections.sort(answer);
        
        return answer;
    }
}