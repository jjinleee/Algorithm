import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {

        // 1. 키패드의 각 숫자에 해당하는 좌표(row, col)를 맵에 저장
        Map<Integer, int[]> keyMap = new HashMap<>();
        int idx = 1;

        // 3x4 형태 키패드를 row, col로 매핑
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 3; col++) {
                if (idx <= 9) {
                    keyMap.put(idx++, new int[]{row, col});
                } else {
                    // * = -1, 0 = 0, # = -2 로 임의 부여
                    if (row == 3 && col == 0) keyMap.put(-1, new int[]{row, col}); // * 자리
                    else if (row == 3 && col == 1) keyMap.put(0, new int[]{row, col}); // 0 자리
                    else if (row == 3 && col == 2) keyMap.put(-2, new int[]{row, col}); // # 자리
                }
            }
        }

        // 2. 결과를 누적할 문자열 빌더
        StringBuilder sb = new StringBuilder();

        // 3. 왼손과 오른손의 시작 위치 (초기 위치)
        int[] left = keyMap.get(-1);  // '*' 위치
        int[] right = keyMap.get(-2); // '#' 위치

        // 4. 주어진 숫자 배열(numbers)을 순회하며 누를 손 결정
        for (int num : numbers) {
            int[] target = keyMap.get(num);  // 현재 눌러야 할 숫자의 좌표

            // 왼손 전용 숫자
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");      // 왼손 사용
                left = target;       // 왼손 위치 갱신
            }
            // 오른손 전용 숫자
            else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");      // 오른손 사용
                right = target;      // 오른손 위치 갱신
            }
            // 가운데 숫자: 2, 5, 8, 0 → 거리 비교
            else {
                // 왼손과 오른손의 거리(맨해튼 거리) 계산
                int leftDist = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
                int rightDist = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);

                // 왼손이 더 가까우면
                if (leftDist < rightDist) {
                    sb.append("L");
                    left = target;
                }
                // 오른손이 더 가까우면
                else if (leftDist > rightDist) {
                    sb.append("R");
                    right = target;
                }
                // 거리가 같다면 → handedness 기준
                else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = target;
                    } else {
                        sb.append("R");
                        right = target;
                    }
                }
            }
        }

        // 결과 문자열로 변환하여 반환
        return sb.toString();
    }
}