import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        Set<String> set = new LinkedHashSet<>();
        
        for (int i = 0; i < L; i++) {
            String input = br.readLine();
            
            if (set.contains(input)) {
                set.remove(input);
            }
            
            set.add(input);
        }
        
        int cnt = 0;
        for (String id : set) {
            if (cnt == K) {
                break;
            }
            bw.write(id + "\n");
            cnt++;
        }
        
        bw.flush();
    }
}