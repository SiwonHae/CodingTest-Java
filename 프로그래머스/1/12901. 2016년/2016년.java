class Solution {
    public String solution(int a, int b) {
        String answer = "";

        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30};

        int date = 0;
        for (int i = 0; i < a - 1; i++) {
            date += month[i];
        }
        date += b - 1; // 배열 인덱스가 0 부터 시작하므로 -1

        answer = day[date % 7];

        return answer;
    }
}