class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // n-1번과 n번이 대결함.
        // A와 B는 항상 이김.
        // 이긴 사람의 다음 라운드 번호는 n/2 (반올림 한다).

        while (a != b) {
            if (a % 2 == 0) {
                a = a / 2;
            } else {
                a = a / 2 + 1;
            }

            if (b % 2 == 0) {
                b = b / 2;
            } else {
                b = b / 2 + 1;
            }

            answer++;
        }

        return answer;
    }
}