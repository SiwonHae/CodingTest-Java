class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int n = 0;
        
        char[] x = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        while (!sb.toString().equals("1")) {
            sb = new StringBuilder();            
            
            for (char c : x) {
                if (c == '1') {
                    sb.append(c);
                } else {
                    zero++;
                }
            }
            
            int c = sb.length();
            x = Integer.toBinaryString(c).toCharArray();
            n++;
        }
        
        answer[0] = n;
        answer[1] = zero;
        
        return answer;
    }
}