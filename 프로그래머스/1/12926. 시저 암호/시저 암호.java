class Solution {

    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) {
                return c;
        }

        // 대문자면 'A', 소문자면 'a'
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int pos = c - offset;
        pos = (pos + n) % 26;

        return (char) (offset + pos);
    }

    public String solution(String s, int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char newC = push(c, n);
            sb.append(newC);
        }

        answer = sb.toString();

        return answer;
    }
}