import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int idx = 0;

        // 다리 길이만큼 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);  // 다리에 트럭 없을 때는 0으로 채움
        }

        while (idx < truck_weights.length) {
            time++;

            // 1초 흐르고, 다리 앞쪽 트럭 제거
            totalWeight -= bridge.poll();

            // 다음 트럭 올릴 수 있는지 확인
            if (totalWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            } else {
                // 못 올라가면 0을 채워서 시간만 흐르게 함
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리 끝까지 가는 시간 추가
        return time + bridge_length;
    }
}