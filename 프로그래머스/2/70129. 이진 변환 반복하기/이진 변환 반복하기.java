class Solution {
    public int[] solution(String s) {
        int countZero = 0;
        int count = 0;
        while(!s.equals("1")){
            count++;
            StringBuilder sb = new StringBuilder();
            char[] arr= s.toCharArray();
            
            for(char x : arr){
                if(x == '1') sb.append(x);
                else countZero++;
            }
            int tmp = sb.toString().length();
        
            s = Integer.toBinaryString(tmp);
        }
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = countZero;
        return answer;
    }
}