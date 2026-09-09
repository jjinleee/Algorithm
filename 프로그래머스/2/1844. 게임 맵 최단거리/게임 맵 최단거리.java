import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    int n,m;
    public int solution(int[][] maps) {
        m=maps.length;
        n=maps[0].length;
        boolean[][] visited=new boolean[m][n];
        
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx>=0 && nx<m && ny>=0 && ny<n && maps[nx][ny]==1 &&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                    maps[nx][ny]+=maps[x][y];
                }
            }
        }
        
        return maps[m-1][n-1]==1 ? -1 : maps[m-1][n-1];
    }
}