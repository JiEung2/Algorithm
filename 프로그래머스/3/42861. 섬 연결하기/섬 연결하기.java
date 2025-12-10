import java.util.*;
class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        for(int i = 0; i < costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) {
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }
        
        
        return answer;
    }
    
    public int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x != y) {
            parent[y] = x;
        }
    }
    
}