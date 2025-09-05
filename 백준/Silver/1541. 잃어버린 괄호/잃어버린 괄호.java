import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        String[] split = input.split("-");

        int result = 0;
        
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            
            String[] numbers = s.split("\\+");
            int sum = 0;
            
            for (String num : numbers) {
                sum += Integer.parseInt(num);
            }
            
            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        
        bw.write(String.valueOf(result)); 
        bw.flush();
    }
}