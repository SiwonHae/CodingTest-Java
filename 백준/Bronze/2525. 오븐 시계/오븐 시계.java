import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        int h = a, m = 0;

        if (b + c < 60) {
            m = b + c;
        } else {
            int hour = (b + c) / 60;
            h += hour;
            if (h > 23) {
                h -= 24;
            }

            m = (b + c) % 60;
        }


        StringBuilder sb = new StringBuilder();
        sb.append(h + " " + m);
        System.out.println(sb);
    }
}
