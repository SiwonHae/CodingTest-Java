import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Deque<Integer> stack = new ArrayDeque<>();

        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                int start = stack.pop();

                if (i - start == 1) { // 레이저
                    result += stack.size();
                } else { // 쇠막대기
                    result += 1;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}