import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            List<Character> list = new LinkedList<>();
            int cursor = 0;

            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (cursor > 0) {
                        cursor--;
                    }
                } else if (c == '>') {
                    if (cursor < list.size()) {
                        cursor++;
                    }
                } else if (c == '-') {
                    if (cursor > 0) {
                        cursor--;
                        list.remove(cursor);
                    }
                } else {
                    list.add(cursor, c);
                    cursor++;
                }
            }

            for (char c : list) {
                bw.write(c);
            }
            bw.write("\n");
        }

        bw.flush();
    }
}