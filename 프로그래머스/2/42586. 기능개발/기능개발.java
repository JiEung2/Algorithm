import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] != 0){
                q.add((100 - progresses[i]) / speeds[i] + 1);
            }
            else q.add((100 - progresses[i]) / speeds[i]);
        }
        
        int count = 1;
        int before = q.poll();
        
        while(!q.isEmpty()) {
            int now = q.poll();
            if(before < now){
                answer.add(count);
                count = 1;
                before = now;
            }else{
                count++;
            }
        }
        answer.add(count);
        return answer;
    }
}