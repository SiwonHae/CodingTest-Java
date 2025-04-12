import java.io.*;

public class Main {
    static int X;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        X = Integer.parseInt(br.readLine());

        while (X > 0) {
            if (X % 2 == 1) {
                result++;
            }
            X /= 2;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}