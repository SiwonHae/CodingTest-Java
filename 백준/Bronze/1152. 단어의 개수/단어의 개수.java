import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = br.readLine();
        s = s.trim();

        String[] str = s.split(" ");

        if (s.equals("")) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str.length);
        System.out.println(sb);
    }
}
