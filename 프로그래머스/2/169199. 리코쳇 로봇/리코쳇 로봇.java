import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        int n=board.length;
        int m=board[0].length();
        
        int sx=0; 
        int sy=0;
        
        char[][] map=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c=board[i].charAt(j);
                if(c=='R'){
                    sx=i;
                    sy=j;
                }
                map[i][j]=c;
            }
        }
        
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{sx,sy,0});
        visited[sx][sy]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int dist=cur[2];
            if(map[cur[0]][cur[1]]=='G') return dist;
            
            for(int i=0;i<4;i++){
                int nx=cur[0];
                int ny=cur[1];
                
                while(true){
                    int tx=nx+dx[i];
                    int ty=ny+dy[i];
                    
                    if(tx>=0 && tx<n &&ty>=0 && ty<m && map[tx][ty]!='D'){
                        nx=tx;
                        ny=ty;
                        
                    } else break;
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