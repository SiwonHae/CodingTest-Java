import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        StringBuffer sf = new StringBuffer(a);
        int reverseA = Integer.parseInt(sf.reverse().toString());
        sf = new StringBuffer(b);
        int reverseB = Integer.parseInt(sf.reverse().toString());

        if (reverseA > reverseB) {
            System.out.println(reverseA);
        } else {
            System.out.println(reverseB);
        }
    }
}
