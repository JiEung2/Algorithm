import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < 9; i++) {
            result.add(new HashSet<>());
        }
        
        result.get(1).add(N);
        
        for(int i = 2; i < 9; i++) {
            Set<Integer> now = result.get(i);
            
            for(int j = 1; j <= i; j++) {
                Set<Integer> pre = result.get(j);
                Set<Integer> pos = result.get(i-j);
                
                for(int num1 : pre) {
                    for(int num2 : pos) {
                        now.add(num1 + num2);
                        now.add(num1 - num2);
                        now.add(num1 * num2);
                        
                        if(num1 != 0 && num2 != 0) {
                            now.add(num1 / num2);
                        }
                    }
                }
            }
            now.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for(Set<Integer> set : result) {
            if(set.contains(number)) {
                return result.indexOf(set);
            }
        }
        
        return -1; 
    }
}