import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        Map<String, String> map = new HashMap<>();
        Map<String, String> message = new HashMap<>();
        
        message.put("Enter", "님이 들어왔습니다.");
        message.put("Leave", "님이 나갔습니다.");
        
        List<String[]> moves = new ArrayList<>();
        
        for(String r : record) {
            String[] records = r.split(" ");
            
            if(records.length == 2) {
                String move = records[0];
                String id = records[1];    
                moves.add(new String[] {id, move});
                continue;
            }
            String move = records[0];
            String id = records[1];
            String nickname = records[2];
            
            if(move.equals("Change")) {
                map.put(id, nickname);
                continue;
            } 
            
            moves.add(new String[] {id, move});
            map.put(id, nickname);
        }
        
        answer = new String[moves.size()];
        
        for(int i = 0; i < moves.size(); i++) {
            String[] move = moves.get(i);
            // System.out.print(move[0] + " " + move[1]);
            // System.out.println(map.get(move[0]));
            answer[i] = map.get(move[0]) + message.get(move[1]);
        }
        
        return answer;
    }
}