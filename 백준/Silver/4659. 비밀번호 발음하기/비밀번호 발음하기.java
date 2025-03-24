import java.io.*;
import java.util.*;

public class Main {
    static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while (!(input = br.readLine()).equals("end")) {
            if (isGood(input)) {
                bw.write("<" + input + ">" + " is acceptable." + "\n");
            } else {
                bw.write("<" + input + ">" + " is not acceptable." + "\n");
            }
        }

        bw.flush();
    }
    
    public static boolean isGood(String input) {
        if (!condition1(input)) {
            return false;
        }
        
        if (!condition2(input)) {
            return false;
        }
        
        if (!condition3(input)) {
            return false;
        }
        
        return true;
    }
    
    public static boolean condition1(String input) {
        int cnt = 0;
        
        for (char c : input.toCharArray()) {
            if (vowels.contains(c)) {
                cnt++;
            }
        }
        
        if (cnt == 0) {
            return false;
        }
        
        return true;
    }
    
    public static boolean condition2(String input) {
        int vowel = 0;
        int consonant = 0;
        
        for (char c : input.toCharArray()) {
            if (vowels.contains(c)) {
                vowel++;
                consonant = 0;
            } else {
                consonant++;
                vowel = 0;
            }
            
            if (vowel == 3 || consonant == 3) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean condition3(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) != 'e' && input.charAt(i) != 'o') {
                return false;
            }
        }
        
        return true;
    }
}