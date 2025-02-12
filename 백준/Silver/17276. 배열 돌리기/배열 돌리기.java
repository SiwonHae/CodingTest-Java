import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (d < 0) {
                d += 360;
            }

            int rotate = d / 45;

            for (int i = 0; i < rotate; i++) {
                clockwise(arr, n);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
    }

    public static void clockwise(int[][] arr, int n) {
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i][n / 2] = tmp[i][i]; // 주 대각선을 가운데 열로 옮긴다.
            arr[i][i] = tmp[n / 2][i]; // 가운데 열을 부 대각선으로 옮긴다.
            arr[n / 2][i] = tmp[n - 1 - i][i]; // 부 대각선을 가운데 행으로 옮긴다.
            arr[n - 1 - i][i] = tmp[n - 1 - i][n / 2]; // 가운데 행을 주 대각선으로 옮긴다.
        }
    }
}