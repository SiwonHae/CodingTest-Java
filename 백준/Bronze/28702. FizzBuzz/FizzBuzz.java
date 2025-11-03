import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        
        int next = 0;
        
        if (!s1.equals("Fizz") && !s1.equals("Buzz") && !s1.equals("FizzBuzz")) {
            next = Integer.parseInt(s1) + 3;
        }
        else if (!s2.equals("Fizz") && !s2.equals("Buzz") && !s2.equals("FizzBuzz")) {
            next = Integer.parseInt(s2) + 2;
        }
        else if (!s3.equals("Fizz") && !s3.equals("Buzz") && !s3.equals("FizzBuzz")) {
            next = Integer.parseInt(s3) + 1;
        }
        
        if (next % 15 == 0) {
            bw.write("FizzBuzz");
        } else if (next % 3 == 0) {
            bw.write("Fizz");
        } else if (next % 5 == 0) {
            bw.write("Buzz");
        } else {
            bw.write(next + "");
        }
        
        bw.flush();
    }
}