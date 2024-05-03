import java.util.*;

class Solution {

    private class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // Ax + By + E = 0
        // Cx + Dy + F = 0
        // 일 때 교점 (x, y)
        // x = (BF - ED) / (AD - BC)
        // y = (EC - AF) / (AD - BC)

        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        // 1로 나눴는데 나머지가 존재하면 실수이다.
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    private Point getMinIntersection(List<Point> intersectionList) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : intersectionList) {
            if (p.x < x) {
                x = p.x;
            }
            if (p.y < y) {
                y = p.y;
            }
        }

        return new Point(x, y);
    }

    private Point getMaxIntersection(List<Point> intersectionList) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : intersectionList) {
            if (p.x > x) {
                x = p.x;
            }
            if (p.y > y) {
                y = p.y;
            }
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {

        List<Point> intersectionList = new ArrayList<>(); // 교점 좌표 저장
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (intersection != null) {
                    intersectionList.add(intersection);
                }
            }
        }

        Point minIntersection = getMinIntersection(intersectionList);
        Point maxIntersection = getMaxIntersection(intersectionList);

        int width = (int) (maxIntersection.x - minIntersection.x + 1);
        int height = (int) (maxIntersection.y - minIntersection.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : intersectionList) {
            int x = (int) (p.x - minIntersection.x);
            int y = (int) (maxIntersection.y - p.y);
            arr[y][x] = '*';
        }

        String[] answer = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = String.valueOf(arr[i]);
        }

        return answer;
    }
}