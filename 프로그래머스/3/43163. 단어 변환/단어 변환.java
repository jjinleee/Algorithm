import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);

        // target에 도달한 적 없다면 0 리턴
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    void dfs(String current, String target, String[] words, boolean[] visited, int depth) {
        if (current.equals(target)) {
            min = Math.min(min, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canConvert(current, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, depth + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    boolean canConvert(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }

        return diff == 1;
    }
}