import java.util.*;

class Solution {
    static final int[] DX = {1, -1, 0, 0};
    static final int[] DY = {0, 0, 1, -1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) g[i] = storage[i].toCharArray();

        for (String req : requests) {
            char ch = req.charAt(0);

            // 크레인: 해당 종류 모두 제거
            if (req.length() == 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (g[i][j] == ch) g[i][j] = '.';
                    }
                }
                continue;
            }

            // 지게차: 접근 가능한 것만 제거
            int H = n + 2, W = m + 2;
            boolean[][] vis = new boolean[H][W];
            ArrayDeque<int[]> q = new ArrayDeque<>();

            // (0,0)에서 시작하는 외부 공기 BFS (확장 격자)
            q.offer(new int[]{0, 0});
            vis[0][0] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + DX[d];
                    int ny = y + DY[d];
                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (vis[nx][ny]) continue;

                    // 실제 창고 내부일 때는 빈칸만 통과
                    if (1 <= nx && nx <= n && 1 <= ny && ny <= m) {
                        if (g[nx - 1][ny - 1] != '.') continue;
                    }
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

            // 접근 가능한 ch 컨테이너 제거
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (g[i][j] != ch) continue;

                    int x = i + 1, y = j + 1; // 확장 격자 좌표
                    boolean accessible = false;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + DX[d];
                        int ny = y + DY[d];
                        if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                        if (vis[nx][ny]) {
                            accessible = true;
                            break;
                        }
                    }
                    if (accessible) g[i][j] = '.';
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (g[i][j] != '.') cnt++;

        return cnt;
    }
}