class Solution {
    public int solution(int[] money) {
        int[] dpO = new int[money.length];
        int[] dpX = new int[money.length];
        int len = money.length;

        dpO[0] = money[0];
        dpO[1] = money[0];

        dpX[0] = 0;
        dpX[1] = money[1];

        for (int i = 2; i < len; i++) {
            dpO[i] = Math.max(dpO[i - 1], money[i] + dpO[i - 2]);
            dpX[i] = Math.max(dpX[i - 1], money[i] + dpX[i - 2]);
        }

        return Math.max(dpO[len - 2], dpX[len - 1]);
    }
}