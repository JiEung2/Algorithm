import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int lp = 0, rp = 9;
        HashMap<String, Integer> w = new HashMap<>();
        for(int i=0; i<want.length; i++){
            w.put(want[i], number[i]);
        }
        while(rp < discount.length){
            HashMap<String, Integer> d = new HashMap<>();
            for(int i = lp; i <= rp; i++){
                d.put(discount[i], d.getOrDefault(discount[i],0)+1);
            }
            int cnt = 0;
            for(String key : w.keySet()){
                if (d.containsKey(key)){
                    if(d.get(key) == w.get(key))
                        cnt++;
                }
                else break;
            }
            if(cnt == w.size()) answer++;
            lp++;
            rp++;
        }
        return answer;
    }
}