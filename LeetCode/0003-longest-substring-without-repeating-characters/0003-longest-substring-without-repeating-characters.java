class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        Set<Character> set = new HashSet<>();
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!set.contains(c)) {
                set.add(c);
            } else {
                result = Math.max(result, set.size());
                set.clear();
                i = idx++;
            }
        }

        result = Math.max(result, set.size());

        return result;
    }
}