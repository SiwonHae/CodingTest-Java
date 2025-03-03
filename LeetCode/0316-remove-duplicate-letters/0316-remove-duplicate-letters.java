class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) - 1);

            if (seen.get(c) != null && seen.get(c) == true) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }

            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}