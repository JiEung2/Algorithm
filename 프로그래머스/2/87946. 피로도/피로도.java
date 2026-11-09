class Solution {
    boolean[] visited;
    int result;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        result = 0;
        visited = new boolean[dungeons.length];
        
        for(int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0]){
                visited[i] = true;
                method(i, dungeons, 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
        
        return result;
    }
    
    public void method(int now, int[][] dungeons, int cnt, int k) {
        result = Math.max(result, cnt);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                method(i, dungeons, cnt + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
        
    }
}