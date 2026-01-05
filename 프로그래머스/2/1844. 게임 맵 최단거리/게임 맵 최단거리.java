import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] check = new int[maps.length][maps[0].length];
        for(int i = 0; i < check.length; i++) {
            for(int j = 0; j < check[i].length; j++) {
                check[i][j] = Integer.MAX_VALUE;
            }
        }
        
        check[0][0] = 1;
        bfs(maps, check, 0, 0);
        
        answer = check[maps.length - 1][maps[0].length - 1];
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] check, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int nx = point[0];
            int ny = point[1];
            
            for(int i = 0; i < 4; i++) {
                int newX = dx[i] + nx;
                int newY = dy[i] + ny;
                
                if(newX >= 0 && newX < maps.length && newY >= 0 && newY < maps[0].length && maps[newX][newY] == 1) {
                    if(check[nx][ny] + 1 < check[newX][newY]) {
                        q.add(new int[] {newX, newY});
                        check[newX][newY] = check[nx][ny] + 1;
                    }
                }
            }
        }
        
    }
    
}