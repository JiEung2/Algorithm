class Solution {
    public String solution(int[] food) {
        String answer = "";
        int[] arr = new int[food.length];
        int sum = 0;
        for(int i=0; i<food.length; i++){
            arr[i] = food[i]/2;
            sum += food[i]/2;
        }
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<arr[i]; j++){
                answer += i;    
            }
        }
        answer += 0;
        for(int i=answer.length()-2; i>=0; i--){
            answer += answer.charAt(i);
        }
        return answer;
    }
}