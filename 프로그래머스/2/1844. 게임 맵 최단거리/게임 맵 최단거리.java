import java.util.*;

class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int n,m;
    public int solution(int[][] maps) {
        n=maps.length;
        m=maps[0].length;
        boolean[][] visited= new boolean[n][m];
        
        int answer=bfs(maps, visited);
        
        return answer==1 ? -1 : answer;
    }
    static int bfs(int[][] maps, boolean[][] visited ){
        Queue<int[]> q=new LinkedList<>();
        
        visited[0][0]=true;
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] current=q.poll();
            int x=current[0];
            int y=current[1];
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && maps[nx][ny]==1 ){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                    maps[nx][ny]+=maps[x][y];
                }
            }
        }
        return maps[n-1][m-1];
        
    }
}