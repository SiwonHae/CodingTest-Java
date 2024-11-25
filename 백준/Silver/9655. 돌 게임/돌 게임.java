import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 1이면 상근 1개
        // 2이면 상근 1개, 창영 1개
        // 3이면 상근 3개
        // 4이면 상근 1개 or 3개, 창영 3개 or 1개
        // 5이면 상근 1개 창영 1개 상근 3개
        // 5이면 상근 1개 창영 3개 상근 1개
        // 5이면 상근 3개 창영 1개 상근 1개
        // 홀수면 상근 승리, 짝수면 창영 승리

        if (N % 2 == 1) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }

        bw.flush();
    }
}