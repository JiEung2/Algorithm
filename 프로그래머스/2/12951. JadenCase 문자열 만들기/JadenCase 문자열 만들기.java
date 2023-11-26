import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if(tmp.length() < 1){
                answer.append(tmp);
            }
            else{
                answer.append(tmp.substring(0,1).toUpperCase());
                answer.append(tmp.substring(1).toLowerCase());
            }
        }
        return answer.toString();
    }
}