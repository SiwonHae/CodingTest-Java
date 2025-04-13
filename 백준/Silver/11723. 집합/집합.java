import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        int n = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            int x = 0;
            if (!cmd.equals("all") && !cmd.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            if (cmd.equals("add")) {
                n |= 1 << x;
            } else if (cmd.equals("remove")) {
                n &= ~(1 << x);
            } else if (cmd.equals("check")) {
                if ((n & (1 << x)) != 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (cmd.equals("toggle")) {
                n ^= (1 << x);
            } else if (cmd.equals("all")) {
                n = (1 << 21) - 1;
            } else if (cmd.equals("empty")) {
                n = 0;
            }
        }

        bw.flush();
    }
}