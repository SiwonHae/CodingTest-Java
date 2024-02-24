class Solution {
    public String solution(String s, int n) {
        String answer = "";

        int diff = 'z' - 'a';

        String[] str = s.split("");
        for (int i = 0; i < s.length(); i++) {
            if (str[i].equals(" ")) {
                answer += " ";
            } else {

                // 소문자 일 때
                if (str[i].charAt(0) >= 'a' && str[i].charAt(0) <= 'z') {
                    if (str[i].charAt(0) + n > 'z') {
                        answer += (char) (str[i].charAt(0) + n - diff - 1);
                    } else {
                        answer += (char) (str[i].charAt(0) + n);
                    }
                }

                // 대문자 일 때
                if (str[i].charAt(0) >= 'A' && str[i].charAt(0) <= 'Z') {
                    if (str[i].charAt(0) + n > 'Z') {
                        answer += (char) (str[i].charAt(0) + n - diff - 1);
                    } else {
                        answer += (char) (str[i].charAt(0) + n);
                    }
                }
            }
        }

        return answer;
    }
}