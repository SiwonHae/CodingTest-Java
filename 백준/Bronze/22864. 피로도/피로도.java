import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        int current = 0;
        for (int i = 0; i < 24; i++) {
            if (current + A <= M) {
                current += A;
                result += B;
            } else {
                current = Math.max(current - C, 0);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}