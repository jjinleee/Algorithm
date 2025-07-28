import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, dist, broken;
        Node(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x, y = cur.y, dist = cur.dist, broken = cur.broken;

            if (x == n - 1 && y == m - 1) return dist;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 벽 아닌 경우
                if (board[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    q.offer(new Node(nx, ny, dist + 1, broken));
                }

                // 벽이고 아직 안 부쉈을 때
                if (board[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new Node(nx, ny, dist + 1, 1));
                }
            }
        }

        return -1;
    }
}