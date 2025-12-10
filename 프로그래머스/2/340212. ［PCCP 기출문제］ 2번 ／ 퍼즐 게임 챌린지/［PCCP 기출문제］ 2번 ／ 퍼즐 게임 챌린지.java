import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
    int n = diffs.length;

    int left = 1;
    int right = 1_000_000_000; // 혹은 max(diffs) 같은 적당한 상한
    int answer = right;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (canSolve(diffs, times, limit, mid)) {
            answer = mid;
            right = mid - 1; // 더 낮은 level로도 가능한지 확인
        } else {
            left = mid + 1;  // 더 높은 level 필요
        }
    }

    return answer;
}

private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
    int n = diffs.length;
    long time = times[0];

    for (int i = 1; i < n; i++) {
        long cur = times[i];
        long prev = times[i-1];

        if (diffs[i] <= level) {
            time += cur;
        } else {
            int d = diffs[i] - level;
            // 이 부분은 long 캐스팅 조심
            time += ((long)prev + (long)cur) * d + cur;
        }

        if (time > limit) return false; // 가지치기
    }

    return time <= limit;
}
}