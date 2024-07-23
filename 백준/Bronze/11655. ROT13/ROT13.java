import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                if (c + 13 <= 'z') {
                    sb.append((char) (c + 13));
                } else {
                    c = (char) (c + 13 - 'z' + 'a' - 1);
                    sb.append(c);
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c + 13 <= 'Z') {
                    sb.append((char) (c + 13));
                } else {
                    c = (char) (c + 13 - 'Z' + 'A' - 1);
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
