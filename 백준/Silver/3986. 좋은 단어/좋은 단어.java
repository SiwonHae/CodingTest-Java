import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}