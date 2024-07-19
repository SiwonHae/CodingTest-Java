import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<String> stack = new Stack<>();
            String[] s = br.readLine().split("");
            boolean isVPS = true;

            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("(")) {
                    stack.add(s[j]);
                } else {
                    if (!stack.isEmpty()) {
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
                bw.write("YES \n");
            } else {
                bw.write("NO \n");
            }
        }

        bw.flush();
    }
}
