import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        Stack<Integer> stack = new Stack<>();
        boolean isValid = true;

        for (int i = 0; i < n; i++) {
            if (arr[i] == start) {
                start++;
            } else {
                if (!stack.isEmpty() && stack.peek() == start) {
                    stack.pop();
                    start++;
                    i--;
                } else {
                    stack.add(arr[i]);
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == start) {
                start++;
                stack.pop();
            } else {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }

        bw.flush();
    }
}
