import java.util.*;
class Solution {
    int[][] arr;
    int result;
    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int [n + 1][n + 1];
        
        for(int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 0;
            arr[wires[i][1]][wires[i][0]] = 0;
            
            answer = Math.min(answer, dfs(wires[i][0], arr, new int[n+1], n));
            
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        return answer;
    }
    
    public int dfs(int start, int[][] arr, int[] check, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int result = 1;
        
        while(!q.isEmpty()) {
            
            int now = q.poll();
            check[now] = 1;
            
            for(int i = 1; i <= n; i++) {
                if(check[i] == 0 && arr[now][i] == 1) {
                    check[i] = 1;
                    q.add(i);
                    result++;
                }
            }
            
        }
        
        int a = Math.max(result, n-result);
        int b = Math.min(result, n-result);
        
        return a - b;
    }
    
}