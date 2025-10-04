class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
            } else if (c >= 'a' && c <= 'z') {
                // 소문자 처리
                char shifted = (char) ((c - 'a' + n) % 26 + 'a');
                sb.append(shifted);
            } else if (c >= 'A' && c <= 'Z') {
                // 대문자 처리
                char shifted = (char) ((c - 'A' + n) % 26 + 'A');
                sb.append(shifted);
            }
        }
        
        return sb.toString();
    }
}