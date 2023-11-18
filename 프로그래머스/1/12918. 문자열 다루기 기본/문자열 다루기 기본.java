class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6) return false;
        char[] arr = s.toCharArray();
        for(char x : arr){
            if(x < '0' || x > '9') return false;
        }
        return answer;
    }
}