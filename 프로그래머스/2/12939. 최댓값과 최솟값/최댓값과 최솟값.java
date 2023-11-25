import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] tmp = s.split(" ");
        int[] arr = new int[tmp.length];

        for(int i=0; i<tmp.length; i++){
            arr[i] = Integer.valueOf(tmp[i]);
        }

        Arrays.sort(arr);

        answer.append(arr[0] + " " + arr[tmp.length-1]);
        return answer.toString();
    }
}