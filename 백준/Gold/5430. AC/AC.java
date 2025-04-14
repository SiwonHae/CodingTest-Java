import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // R = 배열 뒤집기
        // D = 맨 앞 삭제

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Deque<Integer> deque = new ArrayDeque<>();

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();

            int x = 0;
            for (char c : array.toCharArray()) {
                if (Character.isDigit(c)) {
                    x = x * 10 + c - '0';
                } else {
                    if (x > 0) {
                        deque.offer(x);
                        x = 0;
                    }
                }
            }

            if (x > 0) {
                deque.offer(x);
            }

            boolean error = false;
            boolean reverse = false;

            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (reverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (error) {
                bw.write("error\n");
            } else {
                bw.write("[");
                while (!deque.isEmpty()) {
                    if (reverse) {
                        bw.write(String.valueOf(deque.pollLast()));
                    } else {
                        bw.write(String.valueOf(deque.pollFirst()));
                    }

                    if (!deque.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
    }
}