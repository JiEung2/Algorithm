class Solution {
    int[] check;
    int result;
    public int solution(int k, int[][] dungeons) {
        result = 0;
        check = new int[dungeons.length];
        for(int i = 0 ; i < dungeons.length; i++) {
            dfs(i, k, 0, dungeons);
        }
        
        return result;
    }
    
    public void dfs(int index, int now, int depth, int[][] dungeons){
        
        if(depth >= dungeons.length) {
            result = Math.max(result, depth);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(check[i] == 0 && now >= dungeons[i][0]) {
                check[i] = 1;
                dfs(i, now - dungeons[i][1], depth + 1, dungeons);
                check[i] = 0;
            }
        }
        result = Math.max(result, depth);
    }
}