import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int solution(String[] board) {
        int answer = 0;
        int n=board.length;
        int m=board[0].length();
        char[][] b=new char[n][m];
        int sx=-1, sy=-1;
        
        for(int i=0;i<n;i++){
            String s=board[i];
            for(int j=0;j<m;j++){
                b[i][j]=s.charAt(j);
                if(b[i][j]=='R') {
                    sx=i;
                    sy=j; 
                }//로봇현위치 저장
            }
        }
        
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited= new boolean[n][m];
        q.offer(new int[]{sx,sy,0});
        visited[sx][sy]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            int dist=cur[2];
            
            if(b[cx][cy]=='G') return dist;
            
            for(int i=0;i<4;i++){
                int nx=cx;
                int ny=cy;
                
                //미끄러져서 멈출때까지 이동
                while(true){
                    int tx=nx+dx[i];
                    int ty=ny+dy[i];
                    
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m) break;
                    if (b[tx][ty] == 'D') break;

                    nx = tx;
                    ny = ty;      
                }
                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,dist+1});
                }

            }
        }
        
        return -1;
    }
}