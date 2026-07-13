import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int solution(String[] board) {
        int answer = 0;
        int n=board.length;
        int m=board[0].length();
        int[] cur=new int[2];
        
        char[][] map=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c=board[i].charAt(j);
                map[i][j]=c;
                if(c=='R') {
                    cur[0]=i;
                    cur[1]=j;
                }
                
            }
        }
        
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        q.offer(new int[]{cur[0],cur[1],0});
        visited[cur[0]][cur[1]]=true;
        
        while(!q.isEmpty()){
            int[] cu=q.poll();
            int cx=cu[0];
            int cy=cu[1];
            int dist=cu[2];
            
            if(map[cx][cy]=='G') return dist;
            
            for(int i=0;i<4;i++){
                int nx=cx;
                int ny=cy;
                
                while(true){
                    int tx=nx+dx[i];
                    int ty=ny+dy[i];
                    if(tx<0 || tx>=n || ty<0 || ty>=m) break;
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