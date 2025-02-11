import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        // (y, x)
        // 1의 위치 (N/2, N/2)
        // 2의 위치 (N/2 - 1, N/2)
        // 3의 위치 (N/2 - 1, N/2 + 1)
        // 4의 위치 (N/2, N/2 + 1)
        // 5의 위치 (N/2 + 1, N/2 + 1)
        // 6의 위치 (N/2 + 1, N/2)
        // 7의 위치 (N/2 + 1, N/2 - 1)
        // 8의 위치 (N/2, N/2 - 1)
        // 9의 위치 (N/2 - 1, N/2 - 1)

        // 1. 상으로 이동
        // 2. 우로 이동
        // 3. 하로 이동
        // 4. 좌로 이동

        int y = N / 2;
        int x = N / 2;

        int value = 1;
        int move = 1;

        while (true) {
            // 위로 이동
            for (int i = 0; i < move; i++) {
                arr[y--][x] = value++;
            }

            if (value == N * N + 1) {
                break;
            }

            // 우로 이동
            for (int i = 0; i < move; i++) {
                arr[y][x++] = value++;
            }
            move++;

            // 하로 이동
            for (int i = 0; i < move; i++) {
                arr[y++][x] = value++;
            }

            // 좌로 이동
            for (int i = 0; i < move; i++) {
                arr[y][x--] = value++;
            }
            move++;
        }

        int numY = 0;
        int numX = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (num == arr[i][j]) {
                    numY = i + 1;
                    numX = j + 1;
                }

                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.write(numY + " " + numX);
        bw.flush();
    }
}