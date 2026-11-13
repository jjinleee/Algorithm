import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int row = -1, col = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (i % 3 == 0) row++;           // 아래
                else if (i % 3 == 1) col++;      // 오른쪽
                else { row--; col--; }           // 대각선 위

                map[row][col] = num++;
            }
        }

        int[] answer = new int[n * (n + 1) / 2];
        int idx = 0;

        for (int[] m : map) {
            for (int v : m) {
                if (v != 0) answer[idx++] = v;
            }
        }

        return answer;
    }
}