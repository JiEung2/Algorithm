import java.util.*;
class Solution {
    Set<Integer> set;
    int[] check = new int[7];
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        
        dfs(numbers, "", 0);
        
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
        
    }
    
    public void dfs(String numbers, String now, int depth) {
        if (depth > numbers.length()) return;
        
        for (int i = 0; i < numbers.length(); i++) {
            if(check[i] == 0) {
                check[i] = 1;
                set.add(Integer.parseInt(now + numbers.charAt(i)));
                dfs(numbers ,now + numbers.charAt(i), depth + 1);
                check[i] = 0;
            }
        }
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
		
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
 
        return true;
    }
}