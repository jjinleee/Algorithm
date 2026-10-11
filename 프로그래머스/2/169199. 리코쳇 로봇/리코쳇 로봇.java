import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        int sx=0;
        int sy=0;
        int ex=0;
        int ey=0;
        
        int n=board.length;
        int m=board[0].length();
        char[][] map=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=board[i].charAt(j);
                if(map[i][j]=='R'){
                    sx=i;
                    sy=j;
                } else if(map[i][j]=='G'){
                    ex=i;
                    ey=j;
                }
            }
        }
        
        
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{sx,sy,0});
        visited[sx][sy]=true;
        
        int cnt=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            int dist=cur[2];
            
            if(x==ex && y==ey) return dist;
            
            for(int i=0;i<4;i++){
                int nx=x;
                int ny=y;
                
                while(true){
                    
                    int tx= nx+dx[i];
                    int ty= ny+dy[i];
                    
                    if(tx<0 || tx>=n || ty<0 || ty>=m || map[tx][ty]=='D') break;
                    
                    nx=tx;
                    ny=ty;
                }
                
                if(!visited[nx][ny]){
                    q.offer(new int[]{nx,ny,dist+1});
                    visited[nx][ny]=true;
                }
                
            }
        }
        return -1;
    }
}