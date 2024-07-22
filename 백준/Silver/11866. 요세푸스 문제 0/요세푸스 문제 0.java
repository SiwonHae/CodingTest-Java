import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            ll.add(i + 1);
        }

        int start = k;

        int idx = 0;
        sb.append("<");
        while (!ll.isEmpty()) {
            idx = (idx + k - 1) % ll.size();
            sb.append(ll.remove(idx));
            if (!ll.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
    }
}
