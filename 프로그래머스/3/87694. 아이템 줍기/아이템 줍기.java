import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int max = 0;
        for(int i = 0; i < rectangle.length; i++) {
            for(int j = 0; j < 4; j++) {
                max = Math.max(max, rectangle[i][j]);
            }
        }
        
        int[][] map = new int[max * 2 + 1][max * 2 + 1];
        
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
        
        int[][] check = new int[max * 2 + 1][max * 2 + 1];
        
        for(int i = 0; i < check.length; i++) {
            for(int j = 0; j < check.length; j++) {
                check[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(map, check, characterX * 2, characterY * 2);
        
        return check[itemX * 2][itemY * 2] / 2;
    }
    
    public void bfs(int[][] map, int[][] check, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        check[x][y] = 0;
        
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int nx = point[0];
            int ny = point[1];
            
            for(int i = 0; i < 4; i++) {
                int newX = nx + dx[i];
                int newY = ny + dy[i];
                
                if(newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && map[newX][newY] == 1) {
                    if(check[nx][ny] + 1 < check[newX][newY]) {
                        check[newX][newY] = check[nx][ny] + 1;
                        q.add(new int[] {newX, newY});
                    }
                }
            }
        }
    }
    
    public void fill(int[][] map, int x1, int x2, int y1, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(map[i][j] == 1) continue;
                map[i][j] = 1;
            }
        }
    }
    
    public void fillInside(int[][] map, int x1, int x2, int y1, int y2) {
        for(int i = x1 + 1; i < x2; i++) {
            for(int j = y1 + 1; j < y2; j++) {
                map[i][j] = 0;
            }
        }
    }
}