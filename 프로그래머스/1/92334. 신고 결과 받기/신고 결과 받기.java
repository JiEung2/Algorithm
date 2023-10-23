import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> idIdx = new HashMap<>();
        Map<String, Integer> suspendedList = new HashMap<>();
        ArrayList<User> users = new ArrayList<>();
        
        int idx = 0;
        
        for(String name : id_list) {
            idIdx.put(name, idx++);
            users.add(new User(name));
        }
        
        for(String r : report){
            String[] tmp = r.split(" ");
            users.get(idIdx.get(tmp[0])).reportList.add(tmp[1]);
            users.get(idIdx.get(tmp[1])).reportedList.add(tmp[0]);
        }
        
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }
        
        for(User user : users){
             for(String nameReport : user.reportList){
                 if(suspendedList.get(nameReport) != null){
                     answer[idIdx.get(user.name)]++;
                 }
             }
        }
        
        return answer;
    }
}

class User{
        String name;
        HashSet<String> reportList;
        HashSet<String> reportedList;
        public User(String name){
            this.name = name;
            reportList = new HashSet<>();
            reportedList = new HashSet<>();
        }
}