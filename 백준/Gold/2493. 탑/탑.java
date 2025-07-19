import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Tower> stack = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                bw.write("0 ");
                stack.push(new Tower(i, height));
                continue;
            }

            if (stack.peek().height > height) {
                bw.write(stack.peek().idx + " ");
                stack.push(new Tower(i, height));
            } else {
                while (!stack.isEmpty() && height > stack.peek().height) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    bw.write("0 ");
                } else {
                    bw.write(stack.peek().idx + " ");
                }
                stack.push(new Tower(i, height));
            }
        }

        bw.flush();
    }

    static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}