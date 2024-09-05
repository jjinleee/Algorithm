import java.io.*;
import java.util.*;

public class Main {
    static class Virus implements Comparable<Virus> {
        int type, x, y, time;

        public Virus(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Virus other) {
            return this.type - other.type; // 바이러스 타입의 오름차순 정렬
        }
    }

    static int N, K;
    static int[][] lab;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        List<Virus> viruses = new ArrayList<>();

        // 시험관 상태 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] != 0) {
                    viruses.add(new Virus(lab[i][j], i, j, 0)); // 바이러스 정보 저장
                }
            }
        }

        // 바이러스를 번호 순서대로 정렬
        Collections.sort(viruses);

        // S, X, Y 입력받기
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1; // 인덱스가 1부터 시작하므로 -1
        int Y = Integer.parseInt(st.nextToken()) - 1;

        // BFS를 위한 큐 초기화
        Queue<Virus> queue = new LinkedList<>(viruses);

        // BFS를 사용하여 바이러스 확산 시뮬레이션
        while (!queue.isEmpty()) {
            Virus current = queue.poll();

            if (current.time == S) break; // S초가 지나면 종료

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 시험관 범위를 벗어나지 않고, 빈 칸인 경우에만 확산
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (lab[nx][ny] == 0) {
                        lab[nx][ny] = current.type; // 바이러스 확산
                        queue.offer(new Virus(current.type, nx, ny, current.time + 1));
                    }
                }
            }
        }

        // S초 후 (X, Y)의 바이러스 종류 출력
        System.out.println(lab[X][Y]);
    }
}