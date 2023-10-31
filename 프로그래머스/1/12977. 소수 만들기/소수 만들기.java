class Solution {
    int answer = 0;
    public int solution(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int z=j+1; z<nums.length; z++){
                    int sum = nums[i] + nums[j] + nums[z];
                    if(isPrime(sum)) answer++;
                }
            }
        }


        return answer;
    }
    
    public boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}