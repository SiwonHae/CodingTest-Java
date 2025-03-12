class Solution {
    static List<String> result;
    static Map<Character, String> map;
    static StringBuilder sb;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        sb = new StringBuilder();

        dfs(0, digits, sb);

        return result;
    }

    public void dfs(int start, String digits, StringBuilder sb) {
        if (digits.length() == sb.length()) {
            result.add(sb.toString());
            return;
        }

        for (char c : map.get(digits.charAt(start)).toCharArray()) {
            dfs(start + 1, digits, new StringBuilder(sb).append(c));
        }
    }
}