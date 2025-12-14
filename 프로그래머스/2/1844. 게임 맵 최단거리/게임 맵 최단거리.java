import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    int n;
    int m;
    public int solution(int[][] maps) {
        n=maps.length;
        m=maps[0].length;
        
        boolean[][] visited= new boolean[n+1][m+1];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx>=0 && nx<n && ny>=0  && ny<m){
                    if(!visited[nx][ny] && maps[nx][ny]==1){
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny]=true;
                        maps[nx][ny]=maps[x][y]+1;
                    }
                }
            }
        }
        
        return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
    }
}