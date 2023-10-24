import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        int check[] = new int[reserve.length];
        int lcheck[] = new int[lost.length];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int j = 0;
        for(int l : lost){
            for(int i=0; i<reserve.length; i++){
                if(l == reserve[i]){
                    check[i] = 1;
                    lcheck[j] = 1;
                    answer++;
                    break;
                }    
            }
            j++;
        }
        j = 0;
        for(int l : lost){
            
            for(int i=0; i<reserve.length; i++){
                if(check[i] == 1 || lcheck[j] == 1) continue;
                else if((reserve[i] == l-1) || (reserve[i] == l+1)){
                    check[i] = 1;
                    lcheck[j] = 1;
                    answer++;
                    break;
                }
            }
            j++;
        }
        return answer;
    }
}