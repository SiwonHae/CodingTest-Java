class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] words = {"aya", "ye", "woo", "ma"};
        for (String s : babbling) {
            for (String str : words) {
                s = s.replace(str, " ");
            }

            if (s.trim().isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}