class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String str = s.toLowerCase();
        char[] result = str.toCharArray();
        int p = 0;
        int y = 0;

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 'y') {
                y++;
            } else if (result[i] == 'p') {
                p++;
            }
        }
        
        if (y != p) {
            answer = false;
        }

        return answer;
    }
}