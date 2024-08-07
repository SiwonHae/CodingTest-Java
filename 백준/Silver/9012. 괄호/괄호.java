import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;

            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isVPS = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isVPS = false;
            }

            if (isVPS) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
    }
}