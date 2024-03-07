class Solution {
    public int solution(String s) {
        int answer = 0;

        char x = s.charAt(0);
        int sameCnt = 0;
        int otherCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sameCnt == otherCnt) {
                answer++;
                x = s.charAt(i);
            }

            if (s.charAt(i) == x) {
                sameCnt++;
            } else {
                otherCnt++;
            }
        }

        return answer;
    }
}