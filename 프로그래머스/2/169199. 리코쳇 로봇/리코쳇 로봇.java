import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        int m=board.length;
        int n=board[0].length();
        char[][] map=new char[m][n];
        
        int x=0;
        int y=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c=board[i].charAt(j);
                if(c=='R'){
                    x=i;
                    y=j;
                }
                map[i][j]=c;
            }
        }
        
        boolean[][] visited= new boolean[m][n];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{x,y,0});
        visited[x][y]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            int dist=cur[2];
            
            if(map[cx][cy]=='G') return dist;
            
            for(int i=0;i<4;i++){
                int nx=cx;
                int ny=cy;
                while(true){
                    int tx=nx+dx[i];
                    int ty=ny+dy[i];

                    if(tx<0 || tx>=m || ty<0 || ty>=n) break;
                    if(map[tx][ty]=='D') break;

                    nx=tx;
                    ny=ty;  
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