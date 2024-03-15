class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 붕대 감으면 1초마다 bandage[1]의 체력 회복
        // 이때 bandage[0]초 "연속"으로 붕대 감으면 bandage[2]만큼 "추가로" 회복
        // 공격 당하면 초당 회복도 못함!
        int answer = 0;

        int totalTime = attacks[attacks.length - 1][0];

        int success = bandage[0]; // 연속 붕대 감는 시간
        int healPerSecond = bandage[1]; // 초당 회복량
        int addHealth = bandage[2]; // 추가 회복량
        int currentHealth = health; // 현재 체력
        int maxHealth = health; // 최대 체력

        int bandageTime = 0; // 붕대 감고 있는 시간

        int idx = 0;
        for (int i = 1; i <= totalTime; i++) {
            System.out.println("시간 " + i);

            boolean isAttack = false;
            bandageTime++;

            if (idx < attacks.length) {
                int attackTime = attacks[idx][0];
                int attackDamage = attacks[idx][1];

                if (i == attackTime) {
                    System.out.println("공격 시간 " + attackTime + " 공격 데미지 " + attackDamage);
                    bandageTime = 0;
                    currentHealth -= attackDamage;
                    isAttack = true;
                    idx++;
                    System.out.println("몬스터한테 공격 받음! " + " " + currentHealth + " " + bandageTime);
                }
            }

            if (!isAttack) {
                currentHealth += healPerSecond;
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
                System.out.println("초당 체력 회복! " + currentHealth + " " + bandageTime);

                if (bandageTime == success) {
                    currentHealth += addHealth;
                    bandageTime = 0;
                    if (currentHealth > maxHealth) {
                        currentHealth = maxHealth;
                    }
                    System.out.println("연속 붕대 감기 성공! " + currentHealth + " " + bandageTime);
                }
            }

            if (currentHealth <= 0) {
                answer = -1;
                return answer;
            }

            System.out.println("시간 끝");
        }

        answer = currentHealth;

        return answer;
    }
}