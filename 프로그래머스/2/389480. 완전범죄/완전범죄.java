import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1_000_000_000;

        // dp[a] = A 흔적이 a일 때 만들 수 있는 최소 B 흔적
        int[] dp = new int[n];
        Arrays.fill(dp, INF);

        // 처음에는 아무것도 안 훔친 상태만 가능
        dp[0] = 0;

        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];

            // 현재 물건까지 반영한 새 상태
            int[] next = new int[n];
            Arrays.fill(next, INF);

            for (int a = 0; a < n; a++) {
                // 만들 수 없는 상태면 건너뜀
                if (dp[a] == INF) continue;

                // 1. 이 물건을 A가 훔치는 경우
                // A 흔적은 늘고, B 흔적은 그대로
                if (a + aTrace < n) {
                    next[a + aTrace] = Math.min(next[a + aTrace], dp[a]);
                }

                // 2. 이 물건을 B가 훔치는 경우
                // A 흔적은 그대로, B 흔적은 늘어남
                if (dp[a] + bTrace < m) {
                    next[a] = Math.min(next[a], dp[a] + bTrace);
                }
            }

            // 이번 물건 처리 결과를 dp에 반영
            dp = next;
        }

        // A 흔적이 가장 작은 답 찾기
        for (int a = 0; a < n; a++) {
            if (dp[a] < m) return a;
        }

        return -1;
    }
}