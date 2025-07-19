import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int idx = 1;

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (idx <= num) {
                stack.push(idx);
                sb.append("+\n");
                idx++;
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                bw.write("NO");
                bw.flush();
                return;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}