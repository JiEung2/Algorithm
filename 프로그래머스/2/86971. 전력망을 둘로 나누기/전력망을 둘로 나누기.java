import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            list.get(a).remove(Integer.valueOf(b));
            list.get(b).remove(Integer.valueOf(a));
            
            answer = Math.min(Math.abs(n - 2 * bfs(list, n)), answer);
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        return answer;
    }
    
    public int bfs(List<List<Integer>> list, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        q.add(1);
        visited[1] = true;
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : list.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}