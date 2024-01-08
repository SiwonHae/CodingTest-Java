class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] result = new int[200];
        
        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0] + 100; j < lines[i][1] + 100; j++) {
                result[j]++;
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 2) {
                answer++;
            }
        }
        
        return answer;
    }
}