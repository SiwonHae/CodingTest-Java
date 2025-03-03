class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else if (stack.peek() == '{' && c == '}') {
                stack.pop();
            } else if (stack.peek() == '[' && c == ']') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}