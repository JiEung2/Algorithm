class Solution {
    public int solution(int num1, int num2) {
        float a = (float)num1 / num2;
        a *= 1000;
        return (int)a;
    }
}