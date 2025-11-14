import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N + 2];     // 각 스테이지에 머무는 사람 수

        for (int s : stages) {
            if (s <= N) {
                count[s]++;
            }
        }

        double[] fail = new double[N + 1]; // 1 ~ N
        int players = stages.length;       // 해당 스테이지에 도달한 사람 수

        for (int i = 1; i <= N; i++) {
            if (players == 0) {
                fail[i] = 0.0;
            } else {
                fail[i] = (double) count[i] / players;
                players -= count[i];
            }
        }

        // 스테이지 번호 배열
        Integer[] order = new Integer[N];
        for (int i = 0; i < N; i++) {
            order[i] = i + 1;
        }

        // 실패율 내림차순, 같으면 스테이지 번호 오름차순
        Arrays.sort(order, (a, b) -> {
            if (fail[b] > fail[a]) return 1;
            else if (fail[b] < fail[a]) return -1;
            else return Integer.compare(a, b);
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = order[i];
        }

        return answer;
    }
}