class Solution {
    int result;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        result = 0;
        
        dfs(numbers, target, 0, 0);
        
        
        return result;
    }
    
    public void dfs(int[] numbers, int target, int now, int sum) {
        if(now == numbers.length) {
            if(sum == target) result++;
            return;
        }
        
        dfs(numbers, target, now + 1, sum + numbers[now]);
        dfs(numbers, target, now + 1, sum - numbers[now]);
    }
}