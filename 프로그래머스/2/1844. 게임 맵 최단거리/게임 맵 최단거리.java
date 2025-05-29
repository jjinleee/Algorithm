import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
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
                
                // 범위체크
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    //벽이 아니고 방문안했다면
                    if(maps[nx][ny]==1 && !visited[nx][ny]){
                        queue.add(new int[]{nx,ny});
                        maps[nx][ny]=maps[x][y]+1; //개수누적
                        visited[nx][ny]=true;
                    }
                }
            }
        }
        return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
    }
}