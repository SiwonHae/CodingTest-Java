import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] result = new int[100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());

            for (int j = in; j < out; j++) {
                result[j]++;
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (result[i] == 1) {
                sum += a;
            } else if (result[i] == 2) {
                sum += 2 * b;
            } else if (result[i] == 3) {
                sum += 3 * c;
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
