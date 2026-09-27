import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        int n = order.length;

        Stack<Integer> sub = new Stack<>();

        for (int i = 1; i <= n; i++) {

            // 컨테이너 벨트의 상자를 일단 보조 벨트에 넣음
            sub.push(i);

            // 보조 벨트 맨 위가 현재 필요한 상자라면 계속 꺼냄
            while (!sub.isEmpty()
                    && idx < n
                    && sub.peek() == order[idx]) {

                sub.pop();
                answer++;
                idx++;
            }
        }

        return answer;
    }
}