import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> done = new ArrayList<>();
        int order = 0; // 순서
        for (int i = 0; i < words.length; i++) {
            if (done.isEmpty()) {
                done.add(words[i]);
                order = 1; // 첫 번째 사람
                continue;
            }

            if (order == n) {
                order = 1;
            } else {
                order++;
            }

            // 이전 단어의 끝 알파벳인지 확인.
            String prevWord = done.get(i - 1);
            char lastWord = prevWord.charAt(prevWord.length() - 1);
            
            if (words[i].charAt(0) != lastWord) {
                answer[0] = order;
                answer[1] = done.size() / n + 1;
                break;
            }

            // 중복 단어 인지 확인
            if (done.contains(words[i])) {
                answer[0] = order;
                answer[1] = done.size() / n + 1;
                break;
            }

            done.add(words[i]);
        }

        System.out.println(done);

        return answer;
    }
}