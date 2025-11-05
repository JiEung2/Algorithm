import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(true) {
            int min = pq.poll();
            if(min >= K) break;
            if(pq.isEmpty()) return -1;
            int next = pq.poll();
            pq.offer(min + (next * 2));
            answer++;
        }
        
        return answer;
    }
}