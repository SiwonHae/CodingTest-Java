import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, String> nameToGroup = new HashMap<>();
        Map<String, List<String>> groupToName = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            int people = Integer.parseInt(br.readLine());
            for (int j = 0; j < people; j++) {
                String name = br.readLine();
                nameToGroup.put(name, group);
                
                if (!groupToName.containsKey(group)) {
                    groupToName.put(group, new ArrayList<>());
                }
                
                groupToName.get(group).add(name);
            }
        }
        
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int kind = Integer.parseInt(br.readLine());
            
            if (kind == 0) {
                List<String> names = groupToName.get(input);
                Collections.sort(names);
                
                for (String name : names) {
                    bw.write(name + "\n");
                }
            } else {
                bw.write(nameToGroup.get(input) + "\n");
            }
        }
        
        bw.flush();
    }
}