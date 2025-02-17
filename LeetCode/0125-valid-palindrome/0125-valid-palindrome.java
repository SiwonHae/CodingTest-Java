class Solution {
    public boolean isPalindrome(String s) {
        String input = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }

        String origin = sb.toString();
        String reverse = sb.reverse().toString();

        if (origin.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }
}