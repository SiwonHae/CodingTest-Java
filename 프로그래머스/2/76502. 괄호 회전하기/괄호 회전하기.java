import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 올바른 괄호 문자열 체크
            if (check(s)) {
                answer++;
            }
            
            // 문자열 왼쪽으로 i 만큼 회전
            s = rotate(s, i);
        }
        
        return answer;
    }
    
    public boolean check(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == '{') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    
    public String rotate(String s, int x) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        
        sb.append(s.charAt(0));
        
        return sb.toString();
    }
}