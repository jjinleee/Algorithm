import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 연결 리스트의 인덱스 관계를 저장하는 배열
        int[] prev = new int[n]; // 이전 노드의 인덱스
        int[] next = new int[n]; // 다음 노드의 인덱스
        Stack<Integer> removed = new Stack<>(); // 삭제된 행을 저장하는 스택
        
        // 초기 연결 리스트 구성
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // 이전 인덱스 설정
            next[i] = i + 1; // 다음 인덱스 설정
        }
        next[n - 1] = -1; // 마지막 행의 다음을 -1로 설정

        int cursor = k; // 현재 선택된 행

        // 명령어 수행
        for (String command : cmd) {
            String[] parts = command.split(" ");
            char action = parts[0].charAt(0);

            if (action == 'U') { // 위로 이동
                int X = Integer.parseInt(parts[1]);
                while (X-- > 0) cursor = prev[cursor];
            } else if (action == 'D') { // 아래로 이동
                int X = Integer.parseInt(parts[1]);
                while (X-- > 0) cursor = next[cursor];
            } else if (action == 'C') { // 삭제
                removed.push(cursor); // 삭제된 행을 스택에 저장
                int prevIdx = prev[cursor];
                int nextIdx = next[cursor];

                // 현재 노드 제거 (이전과 다음을 연결)
                if (prevIdx != -1) next[prevIdx] = nextIdx;
                if (nextIdx != -1) prev[nextIdx] = prevIdx;

                // 커서 이동 (아래가 있으면 아래로, 아니면 위로)
                cursor = (nextIdx != -1) ? nextIdx : prevIdx;
            } else if (action == 'Z') { // 복구
                int restoreIdx = removed.pop();
                int prevIdx = prev[restoreIdx];
                int nextIdx = next[restoreIdx];

                // 복구 (이전과 다음을 다시 연결)
                if (prevIdx != -1) next[prevIdx] = restoreIdx;
                if (nextIdx != -1) prev[nextIdx] = restoreIdx;
            }
        }

        // 결과 문자열 생성
        StringBuilder result = new StringBuilder("O".repeat(n));
        while (!removed.isEmpty()) {
            result.setCharAt(removed.pop(), 'X'); // 삭제된 행을 'X'로 변경
        }

        return result.toString();
    }
}