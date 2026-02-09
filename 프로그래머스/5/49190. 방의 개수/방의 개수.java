import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int nx = 0;
        int ny = 0;
        
        Map<Node, List<Node>> map = new HashMap<>();
        Node now = new Node(nx, ny);
        map.put(now, new ArrayList<>());
        
        for(int arrow : arrows) {
            for(int i = 0; i < 2; i++) {
                nx = nx + dx[arrow];
                ny = ny + dy[arrow];
                
                Node newNode = new Node(nx, ny);
                
                if(!map.containsKey(newNode)) {
                    List<Node> newList = new ArrayList<>();
                    newList.add(now);
                    map.put(newNode, newList);
                    
                    if (map.get(now) == null) {
                        List<Node> nowList = new ArrayList<>();
                        nowList.add(newNode);
                        map.put(now, nowList);
                    } else {
                        map.get(now).add(newNode);
                    }
                    
                } else if(!map.get(newNode).contains(now)) {
                    map.get(newNode).add(now);
                    map.get(now).add(newNode);
                    answer++;
                }
                
                now = newNode;
            }
        }
        
        return answer;
    }
    
    class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) return false;
            Node node = (Node) obj;
            return this.x == node.x && this.y == node.y;
        }
    }
}