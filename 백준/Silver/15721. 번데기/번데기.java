import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int cmd = Integer.parseInt(br.readLine());

        int bCnt = 0; // 뻔
        int dCnt = 0; // 데기
        int n = 2;

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    bCnt++;
                    if (bCnt == T && cmd == 0) {
                        bw.write(String.valueOf((bCnt + dCnt - 1) % A));
                        bw.flush();
                        return;
                    }
                } else {
                    dCnt++;
                    if (dCnt == T && cmd == 1) {
                        bw.write(String.valueOf((bCnt + dCnt - 1) % A));
                        bw.flush();
                        return;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                bCnt++;
                if (bCnt == T && cmd == 0) {
                    bw.write(String.valueOf((bCnt + dCnt - 1) % A));
                    bw.flush();
                    return;
                }
            }

            for (int i = 0; i < n; i++) {
                dCnt++;
                if (dCnt == T && cmd == 1) {
                    bw.write(String.valueOf((bCnt + dCnt - 1) % A));
                    bw.flush();
                    return;
                }
            }

            n++;
        }
    }
}