import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 바구니의 크기

        int J = Integer.parseInt(br.readLine());
        int[] pos = new int[J];
        for (int i = 0; i < J; i++) {
            pos[i] = Integer.parseInt(br.readLine()) - 1;
        }

        int result = 0;
        int left = 0; // 바구니 왼쪽 끝 위치
        int right = M - 1; // 바구니 오른쪽 끝 위치

        for (int i = 0; i < J; i++) {
            int drop = pos[i];

            if (drop < left) { // 바구니 왼쪽에 떨어지는 경우
                result += left - drop;
                right -= left - drop;
                left = drop;
            } else if (drop > right) { // 바구니 오른쪽에 떨어지는 경우
                result += drop - right;
                left += drop - right;
                right = drop;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}