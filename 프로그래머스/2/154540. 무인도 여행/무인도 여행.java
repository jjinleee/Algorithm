import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int n, m;
    char[][] map;
    boolean[][] visited;

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();             
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    int sum = dfs(i, j);
                    list.add(sum);
                }
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);

        return answer;
    }

    int dfs(int x, int y) {
        visited[x][y] = true;
        int sum = map[x][y] - '0';   

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];    

            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && !visited[nx][ny] && map[nx][ny] != 'X') {
                sum += dfs(nx, ny);
            }
        }
        return sum;
    }
}