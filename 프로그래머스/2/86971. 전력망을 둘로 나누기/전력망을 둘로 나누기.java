import java.util.*;
class Solution {
    int[][] tree;
    public int solution(int n, int[][] wires) {
        int answer = n;
        tree = new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++){
            tree[wires[i][0]][wires[i][1]] = 1;
            tree[wires[i][1]][wires[i][0]] = 1;
        }
        
        int n1=0,n2=0;
        
        for(int i=0; i<wires.length; i++){
            n1 = wires[i][0];
            n2 = wires[i][1];
            
            tree[n1][n2]=0;
            tree[n2][n1]=0;
            
            answer = Math.min(answer, BFS(n,n1));
            
            tree[n1][n2]=1;
            tree[n2][n1]=1;
        }
        
        return answer;
    }
    
    public int BFS(int n, int node){
        int cnt = 1;
        boolean check[] = new boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            int now = q.poll();
            check[now] = true;
            
            for(int i=1; i<n+1; i++){
                if(check[i]) continue;
                if(tree[now][i]==1){
                    q.add(i);
                    cnt++;
                }
            }
            
        }
        return Math.abs(cnt-(n-cnt));
        
    }
}