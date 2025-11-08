import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] added = new int[24]; // 각 시간대에 새로 증설한 서버 수
        int running = 0;           // 현재 시간대에 운영 중인 서버 수
        int answer = 0;            // 총 증설 횟수

        for (int hour = 0; hour < 24; hour++) {
            // k시간이 지나 만료된 서버 제거
            if (hour - k >= 0) {
                running -= added[hour - k];
            }

            // 이 시간대에 필요한 서버 수 (문제 정의 그대로: players[i] / m)
            int required = players[hour] / m;

            // 부족하다면 지금 시간에 추가 증설
            if (running < required) {
                int need = required - running;
                added[hour] += need;
                running += need;
                answer += need;
            }
        }

        return answer;
    }
}