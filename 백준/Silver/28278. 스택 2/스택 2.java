import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = 0;
            if (cmd == 1) {
                x = Integer.parseInt(st.nextToken());
                stack.add(x);
            } else if (cmd == 2) {
                if (!stack.isEmpty()) {
                    bw.write(stack.pop() + "\n");
                } else {
                    bw.write("-1 \n");
                }
            } else if (cmd == 3) {
                bw.write(stack.size() + "\n");
            } else if (cmd == 4) {
                if (stack.isEmpty()) {
                    bw.write("1 \n");
                } else {
                    bw.write("0 \n");
                }
            } else {
                if (!stack.isEmpty()) {
                    bw.write(stack.peek() + "\n");
                } else {
                    bw.write("-1 \n");
                }
            }
        }

        bw.flush();
    }
}
