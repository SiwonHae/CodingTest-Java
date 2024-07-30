import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(br.readLine());

        List<BigInteger> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            boolean flags = false;
            String number = "";

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (Character.isLetter(c) && !flags && !number.equals("")) {
                    flags = true;
                    list.add(new BigInteger(number));
                    number = "";
                } else if (Character.isDigit(c)) {
                    flags = false;
                    number += c;
                }

                if (j == s.length() - 1 && !number.equals("")) {
                    list.add(new BigInteger(number));
                }
            }
        }

        Collections.sort(list);
        for (BigInteger i : list) {
            bw.write(i + "\n");
        }

        bw.flush();
    }
}
