import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");
        Pattern p = Pattern.compile(pattern[0] + ".*" + pattern[1]);

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Matcher m = p.matcher(s);
            if (m.matches()) {
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }
        }

        bw.flush();
    }
}
