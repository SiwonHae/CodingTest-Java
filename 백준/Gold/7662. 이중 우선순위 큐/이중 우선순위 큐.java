import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                
                if (op.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (!map.isEmpty() && n == -1) {
                        int key = map.firstKey();
                        int cnt = map.get(key);
                        
                        if (cnt >= 2) {
                            map.put(key, cnt - 1);
                        } else {
                            map.remove(key);
                        }
                    } else if (!map.isEmpty() && n == 1) {
                        int key = map.lastKey();
                        int cnt = map.get(key);
                        
                        if (cnt >= 2) {
                            map.put(key, cnt - 1);
                        } else {
                            map.remove(key);
                        }
                    }
                }
            }
            
            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                int max = map.lastKey();
                int min = map.firstKey();
                
                bw.write(max + " " + min + "\n");
            }
        }
        
        bw.flush();
    }
}