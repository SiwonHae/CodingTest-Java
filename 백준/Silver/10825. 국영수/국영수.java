import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            
            list.add(new Student(name, korean, eng, math));
        }
        
        Collections.sort(list, (a, b) -> {
            if (a.korean != b.korean) {
                return Integer.compare(b.korean, a.korean);
            }
            
            if (a.eng != b.eng) {
                return Integer.compare(a.eng, b.eng);
            }
            
            if (a.math != b.math) {
                return Integer.compare(b.math, a.math);
            }
            
            return a.name.compareTo(b.name);
        });
        
        for (Student s : list) {
            bw.write(s.name + "\n");
        }
        
        bw.flush();
    }
    
    static class Student {
        String name;
        int korean;
        int eng;
        int math;
        
        public Student(String name, int korean, int eng, int math) {
            this.name = name;
            this.korean = korean;
            this.eng = eng;
            this.math = math;
        }
    }
}