import java.util.*;

class Solution {
    private int maxDungeons = 0;
    private boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return maxDungeons;
    }

    private void dfs(int fatigue, int[][] dungeons, int count) {
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) { // 방문하지 않았고 탐험 가능하면 진행
                visited[i] = true;
                dfs(fatigue - dungeons[i][1], dungeons, count + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}