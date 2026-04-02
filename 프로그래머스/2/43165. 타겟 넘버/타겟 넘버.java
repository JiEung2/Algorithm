class Solution {
    int result;
    public int solution(int[] numbers, int target) {
        result = 0;
        dfs(numbers, 0, 0, target);
        return result;
    }
    
    public void dfs(int[] numbers, int now, int sum, int target) {
        if(now == numbers.length) {
            if(sum == target) result++;
                
            return;
        }

        dfs(numbers, now + 1, sum + numbers[now], target);
        dfs(numbers, now + 1, sum - numbers[now], target);
    }
    
}