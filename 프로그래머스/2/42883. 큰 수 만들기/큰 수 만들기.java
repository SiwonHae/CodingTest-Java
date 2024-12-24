import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        int length = number.length() - k;
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(stack.get(i));
        }
        
        answer = sb.toString();
        
        return answer;
    }
}