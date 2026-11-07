import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = queue1.length;
        int answer = -1;
        long q1Sum = 0;
        long q2Sum = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            q1Sum += queue1[i];
            q1.add(queue1[i]);
            q2Sum += queue2[i];
            q2.add(queue2[i]);
        }
        
        if((q1Sum + q2Sum) % 2 != 0) return answer;
    
        int cnt = 0;
        while(q1Sum != q2Sum) {
            if(cnt > 4 * n) return answer;
            if(q1Sum > q2Sum) {
                int tmp = q1.poll();
                q2.add(tmp);
                q1Sum -= tmp;
                q2Sum += tmp;
            } else {
                int tmp = q2.poll();
                q1.add(tmp);
                q2Sum -= tmp;
                q1Sum += tmp;
            }
            cnt++;
        }
        
        answer = cnt;
        return answer;
    }
}