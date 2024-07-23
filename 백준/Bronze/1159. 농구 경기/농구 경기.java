import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        int[] alphabet = new int[26];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
            alphabet[s[i].charAt(0) - 'a']++;
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] >= 5) {
                cnt++;
                bw.write((char) i + 'a');
            }
        }

        if (cnt == 0) {
            bw.write("PREDAJA");
            bw.flush();
            return;
        }

        bw.flush();
    }
}
