class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        // a개 갖다주면 b개 줌.

        while (n >= a) {
            n = n - a; // a개 가져다 주면
            n += b; // b개를 줌
            answer += b;
        }

        return answer;
    }
}