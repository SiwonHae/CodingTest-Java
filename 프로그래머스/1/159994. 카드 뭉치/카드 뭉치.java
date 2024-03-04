class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int oneIndex = 0;
        int twoIndex = 0;
        String ans = "";
        for (int i = 0; i < goal.length; i++) {
            if (oneIndex == cards1.length) {
                oneIndex = 0;
            }
            if (twoIndex == cards2.length) {
                twoIndex = 0;
            }
            
            if (goal[i].equals(cards1[oneIndex])) {
                ans += cards1[oneIndex] + " ";
                cards1[oneIndex] = "";
                oneIndex++;
            } else if (goal[i].equals(cards2[twoIndex])) {
                ans += cards2[twoIndex] + " ";
                cards2[twoIndex] = "";
                twoIndex++;
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}