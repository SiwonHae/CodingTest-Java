import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int square = 1;
        int result = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            char c = n.charAt(i);

            // A = 10, B = 11 ...
            if (c >= 'A' && c <= 'Z') {
                result += (c - 'A' + 10) * square;
            } else {
                result += (c - '0') * square;
            }

            square *= b;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
