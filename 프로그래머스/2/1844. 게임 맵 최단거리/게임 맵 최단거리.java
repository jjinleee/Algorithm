import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    int n,m;
    int[][] map;
    boolean[][] visited;
    public int solution(int[][] maps) {
        map=maps;
        n=maps.length;
        m=maps[0].length;
        visited=new boolean[n][m];
        
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] &&maps[nx][ny]==1){
                    visited[nx][ny]=true;
                    maps[nx][ny]=map[cx][cy]+1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        
        return map[n-1][m-1]==1 ? -1 : map[n-1][m-1];
    }
}