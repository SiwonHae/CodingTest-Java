class Solution {
    public String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = getPalindrome(s, i, i);   // 홀수 길이 펠린드롬 체크
            String evenPalindrome = getPalindrome(s, i, i + 1); // 짝수 길이 펠린드롬 체크
            
            if (oddPalindrome.length() > result.length()) {
                result = oddPalindrome;
            }
            if (evenPalindrome.length() > result.length()) {
                result = evenPalindrome;
            }
        }

        return result;
    }

    public String getPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}