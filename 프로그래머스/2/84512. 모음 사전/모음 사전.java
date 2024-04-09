import java.util.ArrayList;
import java.util.List;

class Solution {

    static List<String> list = new ArrayList<>();
    static String[] words = {"A", "E", "I", "O", "U"};

    public void dfs(int depth, String s) {
        list.add(s);
        if (depth == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(depth + 1, s + words[i]);
        }
    }

    public int solution(String word) {
        int answer = 0;
        int depth = 0;
        String s = "";

        dfs(depth, s);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                return answer;
            }
        }

        return answer;
    }
}