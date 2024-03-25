class Solution {

    public int getGCD(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        return getGCD(n2, n1 % n2);
    }

    public int getLCM(int[] arr) {
        int gcd = getGCD(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = getGCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }

        return lcm;
    }

    public int solution(int[] arr) {
        int answer = 0;

        // 두 수가 아니라 arr 배열에 있는 수들의 최소 공배수를 구해라.

        answer = getLCM(arr);

        return answer;
    }
}