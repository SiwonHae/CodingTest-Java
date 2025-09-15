import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        List<Long> list = new ArrayList<>();
        
        while (st.hasMoreTokens() && cnt != n) {
            String num = new StringBuilder(st.nextToken()).reverse().toString();
            list.add(Long.parseLong(num));
            cnt++;
        }
        
        while (cnt != n) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String num = new StringBuilder(st.nextToken()).reverse().toString();
                list.add(Long.parseLong(num));
                cnt++;
            }
        }
        
        Collections.sort(list);
        
        for (long x : list) {
            bw.write(x + "\n");
        }
        
        bw.flush();
    }
}