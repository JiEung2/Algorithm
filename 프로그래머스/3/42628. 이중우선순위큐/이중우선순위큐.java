import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        StringTokenizer st;
        
        for(int i = 0 ; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(s.equals("I")) {
                maxQ.offer(num);
                minQ.offer(num);
            } else {
                if(maxQ.isEmpty()) continue;
                if(num == -1) {
                    int now = minQ.poll();
                    maxQ.remove(now);
                }
                else{
                    int now = maxQ.poll();
                    minQ.remove(now);
                }
            }
        }
        
        if(!maxQ.isEmpty()) {
            return new int[] {maxQ.poll(), minQ.poll()};
        }
        
        return new int[] {0, 0};
    }
}