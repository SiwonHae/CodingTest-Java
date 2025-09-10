import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] left = new char[26];
    static char[] right = new char[26];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            char node = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            
            left[node - 'A'] = l;
            right[node - 'A'] = r;
        }
        
        
        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');

        bw.write(sb.toString());
        bw.flush();
    }
    
    public static void preorder(char current) {
        if (current == '.') {
            return;
        }
        
        sb.append(current);
        preorder(left[current - 'A']);
        preorder(right[current - 'A']);
    }
    
    public static void inorder(char current) {
        if (current == '.') {
            return;
        }
        
        inorder(left[current - 'A']);
        sb.append(current);
        inorder(right[current - 'A']);
    }
    
    public static void postorder(char current) {
        if (current == '.') {
            return;
        }
        
        postorder(left[current - 'A']);
        postorder(right[current - 'A']);
        sb.append(current);
    }
}