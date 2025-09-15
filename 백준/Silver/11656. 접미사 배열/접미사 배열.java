import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String S = br.readLine();
        
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < S.length(); i++) {
            list.add(S.substring(i));
        }
        
        Collections.sort(list);
        
        for (String s : list) {
            bw.write(s + "\n");
        }
        
        bw.flush();
    }
}