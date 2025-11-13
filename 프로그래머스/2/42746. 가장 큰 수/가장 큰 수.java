import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        
        for(int number : numbers) {
            String tmp = String.valueOf(number);
            pq.offer(tmp);
        }
        
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        
        if(answer.startsWith("0")) return "0";
        
        return answer;
    }
}