import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        List<String> list = new ArrayList<>();
        list.add(s);

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(0);
            s = s.substring(1, s.length());
            s += c;
            list.add(s);
        }

        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < list.size(); j++) {
            String str = list.get(j);
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == '(') {
                    stack.push(c);
                } else if (c == '{') {
                    stack.push(c);
                } else if (c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
            stack.clear();
        }

        return answer;
    }
}