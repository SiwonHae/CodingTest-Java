class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int[] x = new int[sizes.length];
        int[] y = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] >= sizes[i][1]) {
                x[i] = sizes[i][0];
                y[i] = sizes[i][1];
            } else {
                x[i] = sizes[i][1];
                y[i] = sizes[i][0];
            }
        }

        int w = 0;
        int h = 0;

        for (int i = 0; i < sizes.length; i++) {
            w = Math.max(w, x[i]);
            h = Math.max(h, y[i]);
        }

        answer = w * h;

        return answer;
    }
}