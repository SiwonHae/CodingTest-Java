import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                stack.push(c);
                bw.write(c);
                continue;
            } else if (c == '>') {
                stack.pop();
                bw.write(c);
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == '<') {
                bw.write(c);
            } else if (c == ' ') {
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                bw.write(" ");
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        bw.flush();
    }
}