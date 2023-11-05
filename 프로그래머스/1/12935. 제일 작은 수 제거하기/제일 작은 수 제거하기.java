class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[arr.length-1];
        
        int min = arr[0];
        
        for(int i=1; i<arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }
        
        int i=0;
        for(int num : arr){
            if(num == min) continue;
            else{
                answer[i] = num;
                i++;
            }
        }
        
        return answer;
    }
}