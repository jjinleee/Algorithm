import java.io.*;
import java.util.*;


public class Main { 
    static int cnt=0;
    static boolean[][] visited;
    static int[][] map;
    static int n;
    static List<Integer> homes;
    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n=Integer.parseInt(br.readLine());
        map= new int[n][n];
        visited= new boolean[n][n];
        homes=new ArrayList<>();

        for(int i=0;i<n;i++){
            String s=br.readLine();
            for(int j=0;j<n;j++){
                map[i][j]=s.charAt(j)-'0';
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && map[i][j]==1){
                    homes.add(dfs(i,j));
                    count++;
                }
            }
        }

        //단지수
        System.out.println(count);
        //단지에 속하는 집의 수 오름차순
        Collections.sort(homes);
        for(int h:homes){
            System.out.println(h);
        }


    }
    // DFS로 연결된 집 수 세기
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }
}