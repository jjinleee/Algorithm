import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        // 증설 서버들의 종료 시간
        Queue<Integer> server = new ArrayDeque<>();

        for (int time = 0; time < players.length; time++) {

            // 현재 시간에 운영이 종료된 서버 제거
            while (!server.isEmpty() && server.peek() <= time) {
                server.poll();
            }

            // 현재 이용자 수를 처리하기 위해 필요한 증설 서버 수
            int required = players[time] / m;

            // 현재 운영 중인 서버보다 더 필요한 경우 증설
            if (required > server.size()) {
                int add = required - server.size();

                for (int i = 0; i < add; i++) {
                    server.offer(time + k);
                }

                answer += add;
            }
        }

        return answer;
    }
}