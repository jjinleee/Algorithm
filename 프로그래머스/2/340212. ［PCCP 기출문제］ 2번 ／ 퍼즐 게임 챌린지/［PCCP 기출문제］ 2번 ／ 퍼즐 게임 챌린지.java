import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n=diffs.length;
        int maxDiff = 0;
        for (int d : diffs) {
            if (d > maxDiff) maxDiff = d;
        }

        int left = 1;
        int right = maxDiff;
        int answer = maxDiff;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canClear(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canClear(int[] diffs, int[] times, long limit, int level) {
        int n = diffs.length;
        long time = times[0];

        for (int i = 1; i < n; i++) {
            long cur = times[i];
            long prev = times[i - 1];

            if (diffs[i] <= level) {
                time += cur;
            } else {
                int diffGap = diffs[i] - level;
                long add = ((long) prev + cur) * diffGap + cur;
                time += add;
            }

            if (time > limit) return false;
        }

        return time <= limit;
    }
}