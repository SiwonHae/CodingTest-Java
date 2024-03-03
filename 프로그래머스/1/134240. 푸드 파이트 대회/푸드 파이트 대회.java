class Solution {
    public String solution(int[] food) {
        String answer = "";

        // food[0]은 1로 고정(준비한 물의 양)
        // food[1] 부터 칼로리가 낮은 순으로 음식의 개수
        String front = "";
        String back = "";
        for (int i = 1; i < food.length; i++) {
            int cnt = 0;
            if (food[i] % 2 == 0) {
                while (cnt != (food[i] / 2)) {
                    front += i;
                    cnt++;
                }
            } else {
                while (cnt != (food[i] / 2)) {
                    front += i;
                    cnt++;
                }
            }
        }
        answer += front;
        answer += "0";

        StringBuffer sb = new StringBuffer(front);
        back = sb.reverse().toString();

        answer += back;

        return answer;
    }
}