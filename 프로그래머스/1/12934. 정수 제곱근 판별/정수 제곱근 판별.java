class Solution {
    public long solution(long n) {
        long answer = 0;
        Double tmp = Math.sqrt(n);
        if(tmp == tmp.intValue()){
            answer = (long)Math.pow(tmp + 1,2);
        }
        else return -1;
        return answer;
    }
}