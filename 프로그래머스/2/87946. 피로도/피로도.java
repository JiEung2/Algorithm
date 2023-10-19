class Solution {
    boolean check[];
    int cnt = 0;
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        DFS(0, k, dungeons);
        return cnt;
    }
    
    public void DFS(int L, int k, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && k >= dungeons[i][0]){
                check[i] = true;
                DFS(L+1, k-dungeons[i][1], dungeons);
                check[i] = false;
            }
        }
        cnt = Math.max(L, cnt);
        
    }
}