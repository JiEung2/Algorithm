import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length - 1; i++){
            for(int j=i+1; j<numbers.length; j++){
                int tmp = numbers[i]+numbers[j];
                if(!list.contains(tmp)) list.add(tmp);
            }
        }    
        Collections.sort(list);
        return list;
    }
    
}