class Solution {
    int result;
    public int solution(String begin, String target, String[] words) {
        int[] check = new int[words.length];
        result = Integer.MAX_VALUE;
        
        dfs(words, begin, target, check, 0);
    
        if(result == Integer.MAX_VALUE) result = 0;
        return result;
    }
    
    public void dfs(String[] words, String now, String target, int[] check, int sum) {
        if(now.equals(target)) result = Math.min(result, sum);
        for(int i = 0; i < words.length; i++) {
            int wrong = 0;
            if(check[i] == 1) continue;
            for(int j = 0; j < now.length(); j++) {
                if(now.charAt(j) != words[i].charAt(j)) wrong++;
            }
            if(wrong == 1) {
                check[i] = 1;
                dfs(words, words[i], target, check, sum + 1);
                check[i] = 0;
            }
        }
    }
}