import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[1000];
        for (int i = 123; i <= 987; i++) {
            // 서로 겹치지 않고, 1~9 범위의 3자리 수 찾기
            String num = String.valueOf(i);

            if (num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0') {
                continue;
            }
            if(num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)) {
                continue;
            }

            check[i] = true;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = 123; j <= 987; j++) {
                if (check[j]) {
                    int strikeCnt = 0;
                    int ballCnt = 0;

                    for (int a = 0; a < 3; a++) {
                        char aNum = String.valueOf(num).charAt(a);

                        for (int b = 0; b < 3; b++) {
                            char bNum = String.valueOf(j).charAt(b);

                            if (aNum == bNum && a == b) {
                                strikeCnt++;
                            } else if (aNum == bNum && a != b) {
                                ballCnt++;
                            }
                        }
                    }

                    if (strikeCnt != strike || ballCnt != ball) {
                        check[j] = false;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 123; i <= 987; i++) {
            if (check[i]) {
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}