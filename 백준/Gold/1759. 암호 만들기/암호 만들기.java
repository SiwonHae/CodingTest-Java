import java.io.*;
import java.util.*;

public class Main {
    static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    static int L, C;
    static char[] chars;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        chars = new char[C];
        arr = new char[L];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(chars);
        
        backtrack(0, 0);
        
        bw.write(sb.toString());
        bw.flush();
    }
    
    public static void backtrack(int current, int depth) {
        if (depth == L) {
            if (isValid()) {
                for (int i = 0; i < L; i++) {
                    sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }
        
        for (int i = current; i < C; i++) {
            arr[depth] = chars[i];
            backtrack(i + 1, depth + 1);
        }
    }
    
    public static boolean isValid() {
        int vowelCnt = 0;
        int consonantCnt = 0;
        
        for (int i = 0; i < L; i++) {
            if (vowels.contains(arr[i])) {
                vowelCnt++;
            } else {
                consonantCnt++;
            }
        }
        
        return vowelCnt >= 1 && consonantCnt >= 2;
    }
}