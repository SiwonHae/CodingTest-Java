import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String pattern = br.readLine().replace("*", ".*");

        for (int i = 0; i < N; i++) {
            String name = br.readLine();

            if (Pattern.matches(pattern, name)) {
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }

        }

        bw.flush();
    }
}