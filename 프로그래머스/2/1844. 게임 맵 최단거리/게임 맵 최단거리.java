import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        
        int n=maps.length;
        int m=maps[0].length;
        
        boolean[][] visited= new boolean[n][m];
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0]=true;
        
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int x=current[0];
            int y=current[1];
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny] && maps[nx][ny]==1){
                        queue.offer(new int[]{nx,ny});
                        visited[nx][ny]=true;
                        maps[nx][ny]=maps[x][y]+1;
                    }
                }
            }
            
        }
        
        return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
    }
}