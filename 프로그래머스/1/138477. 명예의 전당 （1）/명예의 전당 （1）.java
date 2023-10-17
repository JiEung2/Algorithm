import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for(int i=0; i<score.length; i++){
            if(pQ.size()<k) pQ.add(score[i]);
            else{
                if(score[i]>pQ.peek()){
                    pQ.poll();
                    pQ.add(score[i]);
                }
            }
            answer[i] = pQ.peek();
        }
        
        
        return answer;
    }
}