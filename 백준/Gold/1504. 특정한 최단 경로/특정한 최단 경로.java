import java.io.*;
import java.util.*;

// 간선을 표현하는 클래스 (도착 노드와 가중치 포함)
class Edge implements Comparable<Edge>{
    int to;
    int weight;

    Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    // 우선순위 큐에서 가중치가 작은 순으로 정렬되도록 설정
    public int compareTo(Edge o){
        return this.weight - o.weight;
    }
}

public class Main {
    // 그래프를 인접 리스트로 표현
    static List<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE; // 무한대 값 설정 (도달 불가능 의미)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 개수 N, 간선 개수 E 입력
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 및 양방향 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        // 반드시 거쳐야 하는 두 정점 v1, v2 입력
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다익스트라를 세 번 실행해서 필요한 모든 최단 거리 구하기
        int[] from1 = dijkstra(1);     // 1번 정점에서의 최단 거리
        int[] fromV1 = dijkstra(v1);   // v1에서의 최단 거리
        int[] fromV2 = dijkstra(v2);   // v2에서의 최단 거리

        // 두 가지 경로 계산:
        // 1 → v1 → v2 → N
        // 1 → v2 → v1 → N
        long path1 = (long)from1[v1] + fromV1[v2] + fromV2[N];
        long path2 = (long)from1[v2] + fromV2[v1] + fromV1[N];

        // 두 경로 중 최소값 선택 (단, 모두 유효한 거리여야 함)
        int result = Integer.MAX_VALUE;
        if (from1[v1] != INF && fromV1[v2] != INF && fromV2[N] != INF) {
            result = (int)Math.min(result, path1);
        }
        if (from1[v2] != INF && fromV2[v1] != INF && fromV1[N] != INF) {
            result = (int)Math.min(result, path2);
        }

        // 도달할 수 없는 경우 -1 출력, 아니면 최단 거리 출력
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    // 다익스트라 알고리즘 구현 (start 정점부터 각 정점까지 최단 거리 계산)
    public static int[] dijkstra(int start){
        int[] dist = new int[graph.length];
        Arrays.fill(dist, INF); // 거리 배열 초기화 (무한대로 설정)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.to;
            int curDist = cur.weight;

            // 이미 더 짧은 경로가 있다면 무시
            if (curDist > dist[curNode]) continue;

            // 인접 노드 순회하며 거리 갱신
            for (Edge next : graph[curNode]) {
                int nextNode = next.to;
                int nextDist = next.weight;

                int newDist = dist[curNode] + nextDist;

                if (dist[nextNode] > newDist) {
                    dist[nextNode] = newDist;
                    pq.add(new Edge(nextNode, newDist));
                }
            }
        }
        return dist; // 시작점으로부터의 최단 거리 배열 반환
    }
}