import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
    
        Queue<int[]> q = new LinkedList<>();
        int sum = truck_weights[0];
        int count = 1;
        int index = 1;
        q.add(new int[] {count, truck_weights[0]});
        
        while(!q.isEmpty()) {
            count++;
            int[] front = q.peek();
            if(count - front[0] == bridge_length){
                // System.out.println("now = " + count);
                // System.out.println("out = " + front[1]);
                q.poll();
                sum -= front[1];
                if(index < truck_weights.length && (sum + truck_weights[index]) <= weight) {
                    sum += truck_weights[index];
                    q.add(new int[] {count, truck_weights[index]});
                    index++;
                }
            }
            else{
                if(index < truck_weights.length && (sum + truck_weights[index]) <= weight) {
                    sum += truck_weights[index];
                    q.add(new int[] {count, truck_weights[index]});
                    index++;
                }
            }
        }
        
        return count;
    }
}