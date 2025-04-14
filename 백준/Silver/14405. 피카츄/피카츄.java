import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        boolean flag = true;
        for (int i = 0; i < S.length(); i++) {
            if (i < S.length() - 1 && (S.substring(i, i + 2).equals("pi") || S.substring(i, i + 2).equals("ka"))) {
                i++;
            } else if (i < S.length() - 2 && S.substring(i, i + 3).equals("chu")) {
                i += 2;
            } else {
                flag = false;
            }
        }

        if (flag) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
    }
}