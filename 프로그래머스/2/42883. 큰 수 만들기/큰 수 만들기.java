class Solution {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        for (char n : number.toCharArray()) {
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < n) {
                sb.setLength(sb.length() - 1);
                k--;
            }

            sb.append(n);
        }

        if (k > 0) sb.setLength(sb.length() - k);

        return sb.toString();
    }

}