class Solution {
    public String[] solution(String my_str, int n) {
        
        int length = 0;
        if (my_str.length() % n == 0) {
            length = my_str.length() / n;
        } else {
            length = my_str.length() / n + 1;
        }
        
        String[] answer = new String[length];
        
        int index = 0;
        for (int i = 0; i < answer.length; i++) {
            
            if (index + n >= my_str.length()) {
                answer[i] = my_str.substring(index);
                break;
            }
            
            answer[i] = my_str.substring(index, index + n);
            index += n;
        }


        return answer;
    }
}