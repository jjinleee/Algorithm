import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        int m=board.length;
        int n=board[0].length();
        char[][] map=new char[m][n];
        
        int[] start=new int[2];
        int[] lever=new int[2];
        int[] dest=new int[2];
        
        for(int i=0;i<m;i++){
            String s=board[i];
            for(int j=0;j<n;j++){
                char c=s.charAt(j);
                if(c=='R'){
                    start[0]=i;
                    start[1]=j;
                } else if(c=='G'){
                    dest[0]=i;
                    dest[1]=j;
                }
                map[i][j]=c;
            }
        }
        
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> q= new LinkedList<>();
        visited[start[0]][start[1]]=true;
        q.offer(new int[]{start[0],start[1],0});
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            int dist=cur[2];
            
            if(x==dest[0] && y==dest[1]) return dist;
            
            for(int i=0;i<4;i++){
                int nx=x;
                int ny=y;
                
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