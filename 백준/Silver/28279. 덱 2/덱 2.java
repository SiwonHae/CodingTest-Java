import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            if (cmd.equals("1")) {
                dq.addFirst(Integer.valueOf(st.nextToken()));
            } else if (cmd.equals("2")) {
                dq.addLast(Integer.valueOf(st.nextToken()));
            } else if (cmd.equals("3")) {
                if (dq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(dq.poll() + "\n");
                }
            } else if (cmd.equals("4")) {
                if (dq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(dq.pollLast() + "\n");
                }
            } else if (cmd.equals("5")) {
                bw.write(dq.size() + "\n");
            } else if (cmd.equals("6")) {
                if (dq.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (cmd.equals("7")) {
                if (dq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(dq.peek() + "\n");
                }
            } else {
                if (dq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(dq.getLast() + "\n");
                }
            }
        }

        bw.flush();
    }
}
