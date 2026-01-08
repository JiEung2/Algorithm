import java.util.*;
class Solution {
    List<String> answer;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        
        answer.add("ICN");
        dfs("ICN", tickets, 0);
        
        
        return answer.toArray(new String[0]);
    }
    
    public boolean dfs(String current, String[][] tickets, int count) {
        if(count == tickets.length){
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                answer.add(tickets[i][1]);
                
                if(dfs(tickets[i][1], tickets, count + 1)) {
                    return true;
                }
                
                visited[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
        return false;
    }
}