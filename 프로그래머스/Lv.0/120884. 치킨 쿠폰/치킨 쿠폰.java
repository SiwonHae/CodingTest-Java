class Solution {
    public int solution(int chicken) {
        int answer = 0;

        int coupon = chicken;

        // 쿠폰 10개당 서비스 1개 + 쿠폰 1개
        while (coupon - 10 >= 0) {
            coupon -= 10;
            answer++;
            coupon++;
        }

        return answer;
    }
}