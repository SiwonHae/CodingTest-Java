import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String S = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        
        for (int i = S.length() - 1; i >= 0; i--) {
            sb.append(S.charAt(i));
            list.add(sb.reverse().toString());
            sb.reverse();
        }
        
        Collections.sort(list);
        
        for (String s : list) {
            bw.write(s + "\n");
        }
        
        bw.flush();
    }
}