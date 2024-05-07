class Solution {
    public String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;

        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
                isUpper = true;
            } else {
                if (isUpper) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                isUpper = !isUpper;
            }
        }

        answer = sb.toString();

        return answer;
    }
}