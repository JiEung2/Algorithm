class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        
        int[] numbers = new int[arr.length / 2 + 1];
        String[] op = new String[arr.length / 2];
        
        int[][] max = new int[numbers.length][numbers.length];
        int[][] min = new int[numbers.length][numbers.length];

        numbers[0] = Integer.parseInt(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(i % 2 == 1) {
                op[i/2] = arr[i];
            } else {
                numbers[i/2] = Integer.parseInt(arr[i]);
            }
        }

        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int d = 0; d < numbers.length; d++) {
            for(int i = 0; i < numbers.length - d; i++) {
                int j = i + d;
                
                if(i == j) {
                    max[i][j] = numbers[i];
                    min[i][j] = numbers[i];
                    continue;
                }
                
                for(int k = i; k < j; k++) {
                    if(op[k].equals("+")) {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k+1][j]);
                    } else if(op[k].equals("-")) {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k+1][j]);
                    }
                }
            }
        }
        
        answer = max[0][numbers.length - 1];
        
        return answer;
    }
}