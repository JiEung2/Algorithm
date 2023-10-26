class Solution {
    int num = 0;
    boolean check[];
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int index=0;
        for(int i=0; i<number.length()-k; i++){
            int max = 0;
            for(int j=index; j <= k+i; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    index = j+1;
                    
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
    
}