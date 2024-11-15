import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String board = br.readLine();
        String a = "AAAA";
        String b = "BB";

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == '.') {
                if (count > 0) {
                    if (count % 2 != 0) {
                        bw.write("-1");
                        bw.flush();
                        return;
                    }

                    while (count >= 4) {
                        sb.append(a);
                        count -= 4;
                    }
                    while (count >= 2) {
                        sb.append(b);
                        count -= 2;
                    }
                }
                sb.append('.');
            } else {
                count++;
            }
        }
        
        if (count > 0) {
            if (count % 2 != 0) {
                bw.write("-1"); 
                bw.flush();
                return;
            }
            while (count >= 4) {
                sb.append(a);
                count -= 4;
            }
            while (count >= 2) {
                sb.append(b);
                count -= 2;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}