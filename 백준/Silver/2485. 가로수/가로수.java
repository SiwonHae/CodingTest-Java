import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;
        for (int i = 0; i < n - 1; i++) {
            int gap = arr[i + 1] - arr[i];
            gcd = gcd(gcd, gap);
        }

        int total = (arr[n - 1] - arr[0]) / gcd;
        int result = total - n + 1;


        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
