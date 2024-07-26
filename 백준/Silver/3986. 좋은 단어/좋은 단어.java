import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(input.charAt(j));
                } else {
                    if (stack.peek() == input.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.push(input.charAt(j));
                    }
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
