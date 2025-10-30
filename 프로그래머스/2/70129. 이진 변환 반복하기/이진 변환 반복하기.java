class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeros = 0;
        int n = 0;
        
        while (!s.equals("1")) {
            int zero = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                }
            }
            zeros += zero;
            n++;
            
            int one = s.length() - zero;
            s = Integer.toString(one, 2);
        }
        
        answer[0] = n;
        answer[1] = zeros;
        
        return answer;
    }
}