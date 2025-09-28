class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        
        int pCnt = 0;
        int yCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'p') {
                pCnt++;
            } else if (c == 'y') {
                yCnt++;
            }
        }
        
        if (pCnt != yCnt) {
            answer = false;
        }

        return answer;
    }
}