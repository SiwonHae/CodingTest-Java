import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] s = br.readLine().split("");
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length; i++) {
            char c = (char) (s[i].charAt(0) - 'a');
            alphabet[c]++;
        }

        for (int i = 0; i < 26; i++) {
            bw.write(alphabet[i] + " ");
        }

        bw.flush();
    }
}
