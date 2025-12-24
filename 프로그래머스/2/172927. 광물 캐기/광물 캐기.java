import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] cost = { // [곡괭이][광물] 피로도
            {1, 1, 1},    // 다이아
            {5, 1, 1},    // 철
            {25, 5, 1}    // 돌
        };

        int totalPicks = picks[0] + picks[1] + picks[2];
        int len = Math.min(minerals.length, totalPicks * 5);

        // 5개씩 끊어서 [다이아, 철, 돌] 개수 저장
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i % 5 == 0) groups.add(new int[3]);
            int[] g = groups.get(groups.size() - 1);

            char c = minerals[i].charAt(0);
            if (c == 'd') g[0]++;       // diamond
            else if (c == 'i') g[1]++;  // iron
            else g[2]++;                // stone
        }

        // 돌 곡괭이로 캤을 때 피로도(25,5,1) 기준 내림차순 정렬
        groups.sort((a, b) ->
            (b[0] * 25 + b[1] * 5 + b[2]) -
            (a[0] * 25 + a[1] * 5 + a[2])
        );

        int ans = 0;
        int idx = 0;

        // 다이아(0) → 철(1) → 돌(2) 순으로 그룹에 배치
        for (int t = 0; t < 3; t++) {
            while (picks[t] > 0 && idx < groups.size()) {
                int[] g = groups.get(idx++);
                ans += g[0] * cost[t][0]
                     + g[1] * cost[t][1]
                     + g[2] * cost[t][2];
                picks[t]--;
            }
        }

        return ans;
    }
}