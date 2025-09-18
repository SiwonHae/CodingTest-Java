import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        
        String[] sSplit = S.split(":");
        String[] eSplit = E.split(":");
        String[] qSplit = Q.split(":");
        
        int startMin = Integer.parseInt(sSplit[0]) * 60 + Integer.parseInt(sSplit[1]);
        int endMin = Integer.parseInt(eSplit[0]) * 60 + Integer.parseInt(eSplit[1]);
        int quitMin = Integer.parseInt(qSplit[0]) * 60 + Integer.parseInt(qSplit[1]);
        
        Set<String> enterSet = new HashSet<>();
        int result = 0;
        
        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String time = st.nextToken();
            String name = st.nextToken();
            
            String[] timeSplit = time.split(":");
            int timeMin = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            if (timeMin <= startMin) {
                enterSet.add(name);
            } else if (timeMin >= endMin && timeMin <= quitMin) {
                if (enterSet.contains(name)) {
                    enterSet.remove(name);
                    result++;
                }
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
}