class Solution {

    public int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
    public int solution(int a, int b) {
        int answer = 0;

        while (true) {
            int n = gcd(a, b);
            if (n == 1) {
                break;
            }
            if (a % n == 0 && b % n == 0) {
                a /= n;
                b /= n;
            } else {
                break;
            }
        }

        System.out.println(a + " " + b);

        while (true) {
            if (b == 1) {
                answer = 1;
                break;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 5 == 0) {
                b /= 5;
            } else {
                answer = 2;
                break;
            }
        }

        return answer;
    }
}