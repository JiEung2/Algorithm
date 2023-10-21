import java.util.*;
class Solution {
    List<Integer> list = new ArrayList<>();
    int cnt = 0;
    public int solution(int[] number) {
        int answer = 0;
    
        for(int i=0; i<number.length; i++){
            list.add(number[i]);
            DFS(i, number);
            list.remove(list.size()-1);
        }
        answer = cnt;
        
        return answer;
    }
    
    public void DFS(int index, int[] number){
        if(list.size() == 3) {
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += list.get(i);
            }
            if(sum == 0) cnt++;
            return;
        }
        for(int i=index+1; i<number.length; i++){
            list.add(number[i]);
            DFS(i, number);
            list.remove(list.size()-1);
        }
    }
}