class Solution {
    public void reverseString(char[] s) {
        char[] temp = new char[s.length];

        for (int i = 0; i < s.length / 2; i++) {
            temp[i] = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp[i];
        }
    }
}