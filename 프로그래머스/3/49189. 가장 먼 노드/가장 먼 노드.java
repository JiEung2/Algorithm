import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            int a = e[0];
            int b = e[1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        
        return bfs(list, n);
    }
    
    public int bfs(List<List<Integer>> list, int n) {
        int max = 0;
        int result = 0;
        int[] visited = new int[n + 1];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0});
        visited[1] = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int node = now[0];
            int dis = now[1];
            
            if(max < dis) {
                max = dis;
                result = 1;
            } else if(max == dis) result++;
            
            for(int i = 0; i < list.get(node).size(); i++) {
                if(visited[list.get(node).get(i)] == 0) {
                    q.add(new int[] {list.get(node).get(i), dis + 1});
                    visited[list.get(node).get(i)] = 1;
                }
            }
        }
        
        return result;
    }
}