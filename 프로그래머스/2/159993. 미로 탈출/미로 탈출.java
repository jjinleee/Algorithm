import java.util.*;

class Solution {
    public int solution(String[] maps) {
        //행렬파악
        int n=maps.length;
        int m=maps[0].length();
        char[][] grid=new char[n][m];
                
        int sx = -1, sy = -1, lx = -1, ly = -1, ex = -1, ey = -1; // 시작점, 레버, 출구 위치

        // 2D 배열로 변환 및 S, L, E 위치 저장
        for (int i = 0; i < n; i++) {
            grid[i] = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'S') { sx = i; sy = j; }
                if (grid[i][j] == 'L') { lx = i; ly = j; }
                if (grid[i][j] == 'E') { ex = i; ey = j; }
            }
        }
    
        int distToLever=bfs(grid,sx,sy,lx,ly,n,m);
        int distToExit=bfs(grid,lx,ly,ex,ey,n,m);
        
        return (distToLever==-1|| distToExit ==-1)?-1:(distToLever+distToExit);
        
    }
    private int bfs(char[][] grid, int startX,int startY, int targetX,int targetY, int n, int m ){
        if(startX==targetX &&startY==targetY) return 0;
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{startX,startY,0});
        visited[startX][startY]=true;
        
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int x=curr[0],y=curr[1],dist=curr[2];
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && grid[nx][ny] != 'X') {
                    if (nx == targetX && ny == targetY) return dist + 1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }            
            }
        }
        return -1;
    }
    
    
}