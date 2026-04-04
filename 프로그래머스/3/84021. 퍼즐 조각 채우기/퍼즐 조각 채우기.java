import java.util.*;
class Solution {
    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};
    List<List<int[]>> g;
    List<List<int[]>> t;
    
    public int solution(int[][] game_board, int[][] table) {
        int result = 0;
        
        g = new ArrayList<>();
        t = new ArrayList<>();
        
        for(int i = 0; i < game_board.length; i++) {
            for(int j = 0; j < game_board.length; j++) {
                if(game_board[i][j] == 0) g.add(bfs(0, game_board, i, j));
                if(table[i][j] == 1) t.add(bfs(1, table, i, j));
            }
        }
        
        boolean[] check = new boolean[t.size()];
        
        for(int i = 0; i < g.size(); i++) {
            for(int j = 0; j < t.size(); j++) {
                if(g.get(i).size() == t.get(j).size() && !check[j]) {
                    if(isCompare(g.get(i), t.get(j))) {
                        check[j] = true;
                        result += t.get(j).size();
                        break;
                    }
                }
            }
        }
        
        return result;
    }
    
    public boolean isCompare(List<int[]> a, List<int[]> b) {
        boolean isSame = false;
        List<int[]> rotated = b;
        for(int k = 0; k < 4; k++) {
            rotated = rotate(rotated);
            boolean flag = true;
            for(int i = 0; i < a.size(); i++) {
                int[] point1 = a.get(i);
                int[] point2 = rotated.get(i);
            
                if(point1[0] != point2[0] || point1[1] != point2[1]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                isSame = true;
                break;
            }
        }
        
        return isSame;
    }
    
    public List<int[]> rotate (List<int[]> a) {
        List<int[]> newOne = new ArrayList<>();
        for(int i = 0; i < a.size(); i++) {
            int[] point = a.get(i);
            newOne.add(new int[] {point[1], -point[0]});
            
        }
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int i = 0; i < newOne.size(); i++) {
            minX = Math.min(newOne.get(i)[0], minX);
            minY = Math.min(newOne.get(i)[1], minY);
        }
        
        for(int i = 0; i < newOne.size(); i++) {
            newOne.get(i)[0] -= minX;
            newOne.get(i)[1] -= minY;
        }
        
        Collections.sort(newOne, (o1, o2) -> {
            if(o1[0] == o2[0]) return Integer.compare(o1[1],o2[1]);
            
            return Integer.compare(o1[0],o2[0]);
        });
        return newOne;
    }
    
    public List<int[]> bfs(int num, int[][] map, int tx, int ty) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {tx, ty});
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {tx, ty});
        map[tx][ty] = -1;
        
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && map[nx][ny] == num) {
                    list.add(new int[]{nx, ny});
                    q.add(new int[]{nx, ny});
                    map[nx][ny] = -1;
                }
            }
        }
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int i = 0; i < list.size(); i++) {
            minX = Math.min(list.get(i)[0], minX);
            minY = Math.min(list.get(i)[1], minY);
        }
        
        for(int i = 0; i < list.size(); i++) {
            list.get(i)[0] -= minX;
            list.get(i)[1] -= minY;
        }
        
        Collections.sort(list, (o1, o2) -> {
            if(o1[0] == o2[0]) return Integer.compare(o1[1],o2[1]);
            
            return Integer.compare(o1[0],o2[0]);
        });
        return list;
    }
}