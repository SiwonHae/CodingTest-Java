class Solution {
    public String solution(int a, int b) {
        
        // 2월 29일까지
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        for (int i = 0; i < a - 1; i++) {
            totalDays += daysInMonth[i];
        }
        
        totalDays += b;
        
        return days[totalDays % 7];
    }
}