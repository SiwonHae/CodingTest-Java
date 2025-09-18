import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String password = st.nextToken();
            
            map.put(url, password);
        }
        
        for (int i = 0; i < M; i++) {
            String find = br.readLine();
            
            bw.write(map.get(find) + "\n");
        }
        
        bw.flush();
    }
}