import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Set<Integer> input = new HashSet<>();
        for (int i = 0; i < n; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            if (input.contains(Integer.parseInt(st.nextToken()))) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
    }
}
