import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((m1,m2)->m2 - m1);
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
            q.add(new int[] {i, priorities[i]});
        }
        
        int count = 1;
        int now = pq.poll();
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            if(tmp[1] == now) {
                if(tmp[0] == location) {
                    answer = count;
                    break;
                }
                now = pq.poll();
                count++;
            }
            q.add(tmp);
        }
        
        
        return answer;
    }
}