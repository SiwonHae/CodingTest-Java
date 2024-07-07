import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m > 45) {
            m -= 45;
        } else if (m < 45) {
            m = m - 45 + 60;
            if (h > 0) {
                h--;
            } else {
                h = 23;
            }
        } else {
            m = 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(h + " " + m);
        System.out.println(sb);
    }
}
