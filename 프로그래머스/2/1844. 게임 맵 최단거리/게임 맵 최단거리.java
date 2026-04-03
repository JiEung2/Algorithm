import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] check;
    int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        check = new int[n][m];
        
        bfs(maps, 0, 0);
        if(check[maps.length - 1][maps[0].length - 1] == 0) return -1;
        return check[maps.length - 1][maps[0].length - 1];
    }
    
    public void bfs(int[][] maps, int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});


        
        check[a][b] = 1;
        
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    if(check[nx][ny] == 0) {
                        check[nx][ny] = check[x][y] + 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
            
        }
    }
}