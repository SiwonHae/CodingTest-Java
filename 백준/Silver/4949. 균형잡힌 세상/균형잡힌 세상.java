import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                bw.flush();
                return;
            }

            Stack<String> stack = new Stack<>();
            String[] s = input.split("");
            boolean isVPS = true;

            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("(")) {
                    stack.add(s[j]);
                } else if (s[j].equals("[")) {
                    stack.add(s[j]);
                } else if (s[j].equals(")")) {
                    if (!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        isVPS = false;
                        break;
                    }
                } else if (s[j].equals("]")) {
                    if (!stack.isEmpty() && stack.peek().equals("[")) {
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
                bw.write("yes \n");
            } else {
                bw.write("no \n");
            }
        }
    }
}
