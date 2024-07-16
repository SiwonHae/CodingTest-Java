import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < m; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        for (int num : a) {
            if (!b.contains(num)) {
                result++;
            }
        }

        for (int num : b) {
            if (!a.contains(num)) {
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
