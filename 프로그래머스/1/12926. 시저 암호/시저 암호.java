class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(char x : arr){
            if(x == ' ') answer += ' ';
            else{
                if(Character.isUpperCase(x)){
                if(x+n > 90) answer += (char)(x+n-26);
                else answer+= (char)(x+n);
                }
                else{
                if(x+n > 122) answer += (char)(x+n-26);
                else answer+= (char)(x+n);
                }    
            }
            
        }
        return answer;
    }
}