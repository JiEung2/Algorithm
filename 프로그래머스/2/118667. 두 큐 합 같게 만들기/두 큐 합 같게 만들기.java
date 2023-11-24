import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1=0, sum2=0;

        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        Queue<Integer> tmpQ = new LinkedList<>();

        while(sum1 != sum2){
            if(answer >= 600000) return -1;
            if(sum1 > sum2){
                int tmp = q1.poll();
                sum1 -= tmp;
                sum2 += tmp;
                q2.add(tmp);
            }
            else{
                int tmp = q2.poll();
                sum2 -= tmp;
                sum1 += tmp;
                q1.add(tmp);
                
            }
            answer++;
            if (q1.equals(tmpQ)) return -1;
        }

        return answer;
    }
}