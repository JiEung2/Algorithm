import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            list.add(new HashSet());
        }
        
        list.get(1).add(N);
        for(int i = 2; i < 9; i++) {
            Set<Integer> now = list.get(i);
            now.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for(int j = 1; j < i; j++) {
                Set<Integer> a = list.get(j);
                Set<Integer> b = list.get(i-j);
                
                for(int num1 : a) {
                    for(int num2 : b) {
                        now.add(num1 + num2);
                        now.add(num1 * num2);
                        now.add(num1 - num2);
                        if(num1 != 0 && num2 != 0){
                            now.add(num1 / num2); 
                        }
                        
                    }
                }
            }
        }
        
        for(Set<Integer> set : list) {
            if(set.contains(number)) return list.indexOf(set);
        }
        
        return -1;
        
    }
}