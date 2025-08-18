import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();

        int result = 0;
        int value = 1;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
                value *= 2;
            } else if (c == '[') {
                stack.push(c);
                value *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }

                if (input.charAt(i - 1) == '(') {
                    result += value;
                }

                stack.pop();
                value /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }

                if (input.charAt(i - 1) == '[') {
                    result += value;
                }

                stack.pop();
                value /= 3;
            }
        }

        if (!stack.isEmpty()) {
            result = 0;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}