import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));
        int now = routes[0][1];
        
        for(int i = 1; i < routes.length; i++) {
            if(now  < routes[i][0]) {
                now = routes[i][1];
                answer++;
                continue;
            }
            now = Math.min(now, routes[i][1]);
        }
        return answer;
    }
}