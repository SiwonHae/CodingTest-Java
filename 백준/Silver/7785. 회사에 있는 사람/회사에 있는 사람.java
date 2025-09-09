import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();
            
            if (cmd.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String name : set) {
            result.add(name);
        }
        
        Collections.sort(result, Collections.reverseOrder());
        
        for (String name : result) {
            bw.write(name);
            bw.newLine();
        }
        bw.flush();
    }
}