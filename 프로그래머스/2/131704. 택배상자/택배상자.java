import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int n = order.length;
        
        int idx = 1;   // 컨베이어에서 다음에 올 박스 번호
        int i = 0;     // order에서 현재 실어야 할 인덱스
        
        while (i < n) {
            int target = order[i]; // 이번에 실어야 할 박스 번호
            
            if (idx == target) {
                // 컨베이어에서 바로 싣기
                idx++;
                answer++;
                i++; // 이 주문 처리 완료
            } else if (!stack.isEmpty() && stack.peek() == target) {
                // 보조 컨테이너에서 싣기
                stack.pop();
                answer++;
                i++; // 이 주문 처리 완료
            } else if (idx <= n) {
                // 아직 컨베이어에 상자가 남아 있으면 일단 스택으로 보냄
                stack.push(idx++);
            } else {
                // 컨베이어도 끝났고, 스택 top도 target이 아님 → 더 이상 방법 없음
                break;
            }
        }
        
        return answer;
    }
}