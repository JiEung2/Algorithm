import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;
        String a = "AEIOU";
        list.add("");
        for(int i=0; i<5; i++){
            DFS(Character.toString(a.charAt(i)), a);
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)) answer = i;
        }
        return answer;
    }
    
    public void DFS(String tmp, String word){
        list.add(tmp);
        if(tmp.length() == 5) return;
        for(int i=0; i<word.length(); i++){
            tmp += word.charAt(i);
            DFS(tmp, word);
            tmp = tmp.substring(0, tmp.length()-1);
        }
    }
}