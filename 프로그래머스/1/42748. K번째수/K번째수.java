import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int length = commands[i][1] - commands[i][0] + 1;
            int arr[] = new int[length];
            int index = 0;
            int k = commands[i][2]-1;
            for(int j = commands[i][0]-1; j<= commands[i][1]-1; j++){
                arr[index] = array[j];
                index++;
            }
            Arrays.sort(arr);
            answer[i] = arr[k];
        }
        
        return answer;
    }
}