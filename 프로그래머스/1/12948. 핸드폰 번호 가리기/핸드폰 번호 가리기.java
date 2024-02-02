class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int hideCnt = phone_number.length() - 4;
        String last = phone_number.substring(phone_number.length() - 4);
        
        for (int i = 0; i < hideCnt; i++) {
            answer += "*";
        }
        answer += last;
        
        return answer;
    }
}