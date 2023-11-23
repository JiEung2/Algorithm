class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        s = s.toUpperCase();
        int cntP = 0, cntY = 0;
        for(char x : s.toCharArray()){
            if(x == 'P') cntP++;
            if(x == 'Y') cntY++;
        }
        
        if(cntP == cntY) return true;

        return answer;
    }
}