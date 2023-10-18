import java.util.*;
class Solution {
    boolean check[] = new boolean[7];
    List<Integer> list = new ArrayList<>();
    public int solution(String numbers) {
        int answer = 0;

        for(int i=0; i<numbers.length(); i++){
            DFS(i+1, numbers, "");
        }
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

        for(int i=0; i<list.size(); i++){
            if(prime(list.get(i))) answer++;
        }

        return answer;
    }
    public void DFS(int L, String numbers, String tmp){
        if(tmp.length() == L){
            int temp = Integer.parseInt(tmp);
            if(!list.contains(temp)) list.add(temp);
            return;
        }

        for(int i=0; i<numbers.length(); i++){
            if(!check[i]){
                tmp += numbers.charAt(i);
                check[i] = true;
                DFS(L, numbers, tmp);
                check[i] = false;
                tmp = tmp.substring(0, tmp.length()-1);
            }
        }
        return;
    }
    public boolean prime(int n){
        if(n == 0 || n == 1) return false;
        for(int i=2; i<n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}