import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int intercept = -1;

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            // 기존 요격 지점으로 처리할 수 없는 경우
            if (start >= intercept) {
                answer++;
                intercept = end;
            }
        }

        return answer;
    }
}