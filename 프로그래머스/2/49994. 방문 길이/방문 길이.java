import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>(); // 방문한 길 저장
        int x = 0, y = 0; // 현재 위치
        
        Map<Character, int[]> directions = new HashMap<>();
        directions.put('U', new int[]{0, 1});
        directions.put('D', new int[]{0, -1});
        directions.put('R', new int[]{1, 0});
        directions.put('L', new int[]{-1, 0});

        for (char dir : dirs.toCharArray()) {
            int nx = x + directions.get(dir)[0];
            int ny = y + directions.get(dir)[1];

            // 경계를 벗어나지 않는 경우만 처리
            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                // 방문한 길을 양방향으로 저장
                String path1 = x + "," + y + "->" + nx + "," + ny;
                String path2 = nx + "," + ny + "->" + x + "," + y;

                visited.add(path1);
                visited.add(path2);

                // 현재 위치 갱신
                x = nx;
                y = ny;
            }
        }
        return visited.size() / 2; // 양방향 저장했으므로 2로 나눠줌
    }
}