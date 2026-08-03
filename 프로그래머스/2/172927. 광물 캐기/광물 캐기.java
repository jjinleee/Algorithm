import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);

        List<int[]> groups = new ArrayList<>();

        // 광물을 5개씩 묶어서 다이아, 철, 돌 개수 저장
        for (int i = 0; i < maxMinerals; i += 5) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5 && j < maxMinerals; j++) {
                if (minerals[j].equals("diamond")) {
                    diamond++;
                } else if (minerals[j].equals("iron")) {
                    iron++;
                } else {
                    stone++;
                }
            }

            groups.add(new int[]{diamond, iron, stone});
        }

        // 돌 곡괭이로 캤을 때 피로도가 큰 묶음부터 정렬
        groups.sort((a, b) -> {
            int fatigueA = a[0] * 25 + a[1] * 5 + a[2];
            int fatigueB = b[0] * 25 + b[1] * 5 + b[2];

            return Integer.compare(fatigueB, fatigueA);
        });

        int answer = 0;

        for (int[] group : groups) {
            int pick;

            if (picks[0] > 0) {
                pick = 0;
                picks[0]--;
            } else if (picks[1] > 0) {
                pick = 1;
                picks[1]--;
            } else {
                pick = 2;
                picks[2]--;
            }

            int diamond = group[0];
            int iron = group[1];
            int stone = group[2];

            if (pick == 0) {
                answer += diamond + iron + stone;
            } else if (pick == 1) {
                answer += diamond * 5 + iron + stone;
            } else {
                answer += diamond * 25 + iron * 5 + stone;
            }
        }

        return answer;
    }
}