import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        List<BigInteger> result = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            
            List<String> nums = parse(input);
            for (int j = 0; j < nums.size(); j++) {
                result.add(new BigInteger(nums.get(j)));
            }
        }
        
        Collections.sort(result);
        
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }
        
        bw.flush();
    }
    
    public static List<String> parse(String input) {
        List<String> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        boolean seq = false;
        
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (sb.length() != 0) {
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        
        if (sb.length() != 0) {
            list.add(sb.toString());
        }
        
        return list;
    }
}