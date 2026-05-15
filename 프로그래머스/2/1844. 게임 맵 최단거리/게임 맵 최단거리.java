import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};

    public int solution(int[][] maps) {
        int answer = 0;
        int n=maps.length;
        int m=maps[0].length;
        
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        visited[0][0]=true;
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
           int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && maps[nx][ny]!=0){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                    maps[nx][ny]+=maps[cx][cy];
                }
            }
        }
        
        return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
    }
}