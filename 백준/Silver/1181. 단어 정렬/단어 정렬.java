import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());

        List<String> str = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (!list.contains(s)) {
                str.add(s);
            }
            list.add(s);
        }

        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (String s : str) {
            bw.write(s + "\n");
        }

        bw.flush();
    }
}
