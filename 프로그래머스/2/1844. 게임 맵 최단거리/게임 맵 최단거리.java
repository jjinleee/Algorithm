import java.util.*;

class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int n,m;
    static boolean[][] visited;
    static Queue<int[]> queue=new LinkedList<>();
    
    public int solution(int[][] maps) {
        n=maps.length;
        m=maps[0].length;
        
        visited=new boolean[n][m];
        queue.offer(new int[]{0,0});
        visited[0][0]=true;
        
        bfs(maps);
        
        return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
    }
    
    static void bfs(int[][] maps){ 
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int x=current[0];
            int y=current[1];
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if( nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny] && maps[nx][ny]==1){
                        visited[nx][ny]=true;
                        maps[nx][ny]=maps[x][y]+1;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}