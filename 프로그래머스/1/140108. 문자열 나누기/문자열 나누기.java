class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] c = s.toCharArray();
        boolean flag = true;
        char target =' ';
        int same = 0, diff = 0;
        for(int i=0; i<c.length; i++){
            if(flag){
                if(i==(c.length-1)) answer++;
                flag = false;
                target = c[i];
                same++;
            }
            else{
                if(target == c[i]){
                    same++;
                }
                else diff++;
                
                if(same == diff){
                    same = 0;
                    diff = 0;
                    flag = true;
                    answer ++;
                }
                else if(same != diff && i == c.length-1) answer++;
            }
        }
        
        return answer;
    }
}