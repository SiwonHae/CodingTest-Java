import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();

            boolean isValid = true;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '(' && c == ')') {
                            stack.pop();
                        } else if (stack.peek() == '[' && c == ']') {
                            stack.pop();
                        } else {
                            isValid = false;
                            break;
                        }
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
    }
}