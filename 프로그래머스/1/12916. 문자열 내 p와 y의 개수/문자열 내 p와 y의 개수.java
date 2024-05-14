class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int p = 0;
        int y = 0;
        
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (c == 'p') {
                p++;
            } else if (c == 'y') {
                y++;
            }
        }
        
        if (p != y) {
            answer = false;
        }

        return answer;
    }
}