import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String octalNumber = br.readLine();
        String[] octal = {"000", "001", "010", "011", "100", "101", "110", "111"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < octalNumber.length(); i++) {
            int digit = octalNumber.charAt(i) - '0';
            sb.append(octal[digit]);
        }

        if (octalNumber.equals("0")) {
            bw.write("0");
            bw.flush();
            return;
        }

        while (sb.charAt(0) == '0') {
            sb = new StringBuilder(sb.substring(1));
        }

        bw.write(sb.toString());
        bw.flush();
    }
}