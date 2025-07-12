import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] arr = new int[10];

        int result = A * B * C;
        while (result > 0) {
            arr[result % 10]++;
            result /= 10;
        }

        for (int i = 0; i < 10; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
    }
}