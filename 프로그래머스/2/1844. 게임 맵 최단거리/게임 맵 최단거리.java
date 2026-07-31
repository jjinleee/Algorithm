import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q= new LinkedList<>();
        boolean[][] visited=new boolean[n][m];;
        q.offer(new int[]{0,0});
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && maps[nx][ny]==1 ){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                    maps[nx][ny]+=maps[cur[0]][cur[1]];
                }
            }
        }
        
        
        
        return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
    }
}