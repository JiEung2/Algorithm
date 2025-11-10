import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int index = 0;
        int currentTime = 0;
        int totalTime = 0;
        
        while(index < jobs.length || !pq.isEmpty()) {
            while(index < jobs.length && jobs[index][0] <= currentTime) {
                pq.offer(jobs[index++]);
            }
            
            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                currentTime += job[1];
                totalTime += currentTime - job[0];
            } else{
                currentTime = jobs[index][0];
            }
            
        }
        return totalTime / jobs.length;
    }
}