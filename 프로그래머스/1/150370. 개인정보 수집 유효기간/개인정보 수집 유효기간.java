import java.util.*;
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int curYear = Integer.parseInt(today.split("\\.")[0]);
        int curMonth = Integer.parseInt(today.split("\\.")[1]);
        int curDay = Integer.parseInt(today.split("\\.")[2]);
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String term : terms){
            String tmp = term.split(" ")[0];
            int m = Integer.parseInt(term.split(" ")[1]);
            map.put(tmp, m);
        }
        int cur = curYear*12*28+curMonth*28+curDay;
        for(int i=0; i<privacies.length; i++){
            String[] tmpDate = privacies[i].split(" ");
            int year = Integer.parseInt(tmpDate[0].split("\\.")[0]);
            int month = Integer.parseInt(tmpDate[0].split("\\.")[1]);
            int day = Integer.parseInt(tmpDate[0].split("\\.")[2]);
            
            String tmp = privacies[i].split(" ")[1];
            int term = map.get(tmp);
            month+=term;
            if(month > 12) {
                year += (month/12);
                if(month%12 == 0){
                    year--;
                    month = 12;
                }
                else{
                    month %= 12;
                }
                
            }
            
            if((year*12*28+month*28+day)<=cur) answer.add(i+1);
        }
        
        return answer;
    }
}