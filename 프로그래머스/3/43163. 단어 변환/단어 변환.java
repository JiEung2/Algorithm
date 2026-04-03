class Solution {
    int result;
    int[] check;
    public int solution(String begin, String target, String[] words) {
        result = Integer.MAX_VALUE;
        check = new int[words.length];
        dfs(words, begin, 0, target);
        
        if(result == Integer.MAX_VALUE) return 0;
        return result;
    }
    
    public void dfs(String[] words, String now, int cnt, String target) {
        // System.out.println("now = " + now);
        if(now.equals(target)) {
            result = Math.min(result, cnt);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(check[i] == 0 && checkWords(words[i], now)) {
                check[i] = 1;
                dfs(words, words[i], cnt + 1, target);
                check[i] = 0;
            }
        }
    }
    
    public boolean checkWords(String before, String next) {
        int dif = 0;
        // System.out.println("before = " + before);
        // System.out.println("next = " + next);
        for(int i = 0; i < before.length(); i++) {
            // System.out.println("비교 = " + (before.charAt(i) == next.charAt(i)));
            if(before.charAt(i) != next.charAt(i)) dif++;
        }
        
        // System.out.println("dif = " + dif);
        if(dif == 1) return true;
        
        return false;
    }
}