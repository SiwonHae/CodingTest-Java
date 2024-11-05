import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = N; i >= 0; i--) {
            boolean flags = true;
            int temp = i;

            while (temp > 0) {
                int remainder = temp % 10;

                if (!list.contains(remainder)) {
                    flags = false;
                    break;
                }

                temp /= 10;
            }

            if (flags) {
                bw.write(String.valueOf(i));
                bw.flush();
                return;
            }
        }

        bw.flush();
    }
}