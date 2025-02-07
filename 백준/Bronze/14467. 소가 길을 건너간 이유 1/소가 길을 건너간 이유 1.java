import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        Arrays.fill(arr, -1);

        Set<Integer> set = new HashSet<>();

        int result = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            set.add(a);

            if (arr[a] != b) {
                result++;
            }
            arr[a] = b;
        }

        result -= set.size();

        bw.write(String.valueOf(result));
        bw.flush();
    }
}