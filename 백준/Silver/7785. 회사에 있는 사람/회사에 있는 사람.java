import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Map<String, String> input = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();
            input.put(name, command);
        }

        List<String> nameList = new ArrayList<>(input.keySet());
        Collections.sort(nameList, Collections.reverseOrder());

        for (int i = 0; i < nameList.size(); i++) {
            if (input.get(nameList.get(i)).equals("enter")) {
                bw.write(nameList.get(i) + "\n");
            }
        }

        bw.flush();
    }
}
