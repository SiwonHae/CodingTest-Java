import java.util.*;

class Solution {

    private List<String> splitToken(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < source.length(); i += length) {
            int endIdx = Math.min(i + length, source.length());
            tokens.add(source.substring(i, endIdx));
        }
        
        return tokens;
    }

    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        String prev = "";
        int cnt = 0;
        for (String token : splitToken(source, length)) {
            if (token.equals(prev)) {
                cnt++;
            } else {
                if (cnt > 1) {
                    sb.append(cnt);
                }
                sb.append(prev);
                prev = token;
                cnt = 1;
            }
        }

        if (cnt > 1) {
            sb.append(cnt);
        }
        sb.append(prev);

        return sb.length();
    }

    public int solution(String s) {
        int answer = 0;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            int result = compress(s, i);
            if (result < min) {
                min = result;
            }
        }

        answer = min;
        return answer;
    }
}