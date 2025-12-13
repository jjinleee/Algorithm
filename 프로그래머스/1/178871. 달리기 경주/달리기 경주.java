import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> pos = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            pos.put(players[i], i);
        }

        for (String c : callings) {
            int i = pos.get(c);

            String front = players[i - 1];

            // 배열 swap
            players[i - 1] = c;
            players[i] = front;

            // 위치 갱신
            pos.put(c, i - 1);
            pos.put(front, i);
        }

        return players;
    }
}