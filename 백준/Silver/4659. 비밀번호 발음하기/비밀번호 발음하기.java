import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            boolean hasVowel = false;

            boolean hasThreeSeq = false;
            int vowelSeqCnt = 0;
            int consonantSeqCnt = 0;

            boolean hasDoubleSeq = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (isVowel(c)) {
                    hasVowel = true;
                    vowelSeqCnt++;
                    consonantSeqCnt = 0;
                } else {
                    consonantSeqCnt++;
                    vowelSeqCnt = 0;
                }

                if (vowelSeqCnt >= 3 || consonantSeqCnt >= 3) {
                    hasThreeSeq = true;
                    break;
                }

                if (i < s.length() - 1) {
                    char c2 = s.charAt(i + 1);
                    if (c == c2) {
                        if (c != 'e' && c != 'o') {
                            hasDoubleSeq = true;
                        }
                    }
                }
            }

            if (!hasVowel || hasThreeSeq || hasDoubleSeq) {
                bw.write("<" + s + "> is not acceptable.\n");
            } else {
                bw.write("<" + s + "> is acceptable.\n");
            }
        }

        bw.flush();
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
