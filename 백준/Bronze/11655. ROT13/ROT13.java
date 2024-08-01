import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // 대문자
            if (c >= 'A' && c <= 'Z') {
                if (c + 13 > 'Z') {
                    c = (char) (c + 13 - 'Z' + 'A' - 1);
                } else {
                    c += 13;
                }
            } else if (c >= 'a' && c <= 'z') { // 소문자
                if (c + 13 > 'z') {
                    c = (char) (c + 13 - 'z' + 'a' - 1);
                } else {
                    c += 13;
                }
            }

            sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
