import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        for (int i = 0; i < N; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            String word = br.readLine();
            
            for (char c : word.toCharArray()) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
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