import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 소문자
            if (c >= 'a' && c <= 'z') {
                if ((c + 13) % 'a' >= 26) {
                    c += 13;
                    c -= 26;
                } else {
                    c += 13;
                }
            }

            // 대문자
            if (c >= 'A' && c <= 'Z') {
                if ((c + 13) % 'A' >= 26) {
                    c += 13;
                    c -= 26;
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