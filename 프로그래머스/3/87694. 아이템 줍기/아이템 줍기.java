import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] check;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int max = 0;
        
        for(int i = 0; i < rectangle.length; i++) {
            for(int j = 0; j < 4; j++) {
                max = Math.max(max, rectangle[i][j]);
            }
        }
        
        int[][] map = new int[max * 2 + 1][max * 2 + 1];
        check = new int[max * 2 + 1][max * 2 + 1];
        
        for(int i = 0; i < check.length; i++) {
            for(int j = 0; j < check.length; j++) {
                check[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            fill(map, x1, x2, y1, y2);
        }
        
        for(int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            fillInside(map, x1, x2, y1, y2);
        }
        
        bfs(map, characterX * 2, characterY * 2);
        
        return check[itemX * 2][itemY * 2] / 2;
    }
    
    public void bfs(int[][] map, int cX, int cY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {cX, cY});
        check[cX][cY] = 0;
        
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && map[nx][ny] == 1) {
                    if(check[nx][ny] == Integer.MAX_VALUE) {
                        check[nx][ny] = check[x][y] + 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        
    }
    
    public void fill(int[][] map, int x1, int x2, int y1, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                map[i][j] = 1;
            }
        }
    }
    
    public void fillInside(int[][] map, int x1, int x2, int y1, int y2) {
        for(int i = x1+1; i < x2; i++) {
            for(int j = y1+1; j < y2; j++) {
                map[i][j] = 0;
            }
        }
    }
}