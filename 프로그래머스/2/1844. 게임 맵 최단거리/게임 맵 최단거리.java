import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n=maps.length;
        int m=maps[0].length;
        
        //이동
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        //방문배열, 큐 생성
        boolean[][] visited= new boolean[n][m];
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0}); //시작
        visited[0][0]=true; //방문체크
        
        //큐가빌때까지
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            int x=now[0];
            int y=now[1];
            
            //상하좌우로 이동
            for(int i=0;i<4;i++){
               int nx=x+dx[i];
               int ny=y+dy[i];
               
               if(nx>=0 && nx<n && ny>=0 && ny<m){ //범위체크
                    if(!visited[nx][ny] && maps[nx][ny]==1){//미방문 && 길
                        //큐에넣고 방문체크
                        queue.offer(new int[]{nx,ny});
                        visited[nx][ny]=true;
                        maps[nx][ny]=maps[x][y]+1;//현재거리+1
                    }
               }
            }
        }
        
        return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
    }
}