import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        boolean[] seen = new boolean[1000001];
        int result = 0;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int target = x - a;

            if (target > 0 && target < 1000001 && seen[target]) {
                result++;
            }
            
            seen[a] = true;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}