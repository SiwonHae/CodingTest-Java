import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int bucket = 1;
        int result = 0;
        st = new StringTokenizer(br.readLine());
        int j = Integer.parseInt(st.nextToken());
        for (int i = 0; i < j; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());

            if (pos >= bucket && pos <= bucket + m - 1) {
                continue;
            }

            if (bucket < pos) {
                while (true) {
                    if (pos >= bucket && pos <= bucket + m - 1) {
                        break;
                    }
                    result++;
                    bucket++; // 바구니의 오른쪽 이동
                }
            } else {
                while (true) {
                    if (pos >= bucket && pos <= bucket + m - 1) {
                        break;
                    }
                    result++;
                    bucket--; // 바구니의 왼쪽 이동
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
