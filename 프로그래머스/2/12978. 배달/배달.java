import java.util.*;

class Solution {

    // 마을 번호와 거리를 저장하는 클래스
    static class Node {
        int village;
        int distance;

        Node(int village, int distance) {
            this.village = village;
            this.distance = distance;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // graph[i]에는 i번 마을과 연결된 도로 정보가 저장됨
        List<Node>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 도로는 양방향이므로 양쪽 마을에 모두 저장
        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int cost = r[2];

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }

        // dist[i]는 1번 마을에서 i번 마을까지의 최소 이동 시간
        int[] dist = new int[N + 1];

        // 아직 최단거리를 구하지 않은 상태이므로 큰 값으로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작점인 1번 마을까지의 거리는 0
        dist[1] = 0;

        // 1번 마을에서의 누적 이동 시간이 작은 노드부터 꺼내기 위한 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.distance, b.distance)
        );

        // 1번 마을부터 탐색 시작
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int currentVillage = current.village;
            int currentDistance = current.distance;

            // 큐에 저장된 거리보다 이미 더 짧은 경로를 찾은 경우
            // 현재 정보는 오래된 정보이므로 탐색하지 않음
            if (currentDistance > dist[currentVillage]) {
                continue;
            }

            // 현재 마을과 연결된 모든 도로 탐색
            for (Node next : graph[currentVillage]) {
                int nextVillage = next.village;

                // 현재 마을까지의 거리 + 다음 도로의 이동 시간
                int newDistance = currentDistance + next.distance;

                // 기존에 알고 있던 거리보다 더 짧은 경로를 발견한 경우
                if (newDistance < dist[nextVillage]) {
                    // 최단거리 갱신
                    dist[nextVillage] = newDistance;

                    // 갱신된 거리 정보를 우선순위 큐에 추가
                    pq.offer(new Node(nextVillage, newDistance));
                }
            }
        }

        // 1번 마을에서 K시간 이하로 도착할 수 있는 마을 개수 계산
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}