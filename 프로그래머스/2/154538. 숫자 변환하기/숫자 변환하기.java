import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[y + 1];
        Arrays.fill(dist, -1); 
        
        q.add(x);
        dist[x] = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == y) return dist[now];
            
            int[] arr = {now + n, now * 2, now * 3};
            for(int next : arr) {
                if (next > y) continue;
                if (dist[next] != -1) continue;
                dist[next] = dist[now] + 1;
                q.add(next);
            }
        }
        
        
        return -1;
    }
}