import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    char[][] map;
    int m,n;
    public int solution(String[] maps) {
        m=maps.length;
        n=maps[0].length();
        map=new char[m][n];
        
        int sx=0; 
        int sy=0;
        int ex=0;
        int ey=0;;
        int lx=0;
        int ly=0;
        
        for(int i=0;i<m;i++){
            String s=maps[i];
            for(int j=0;j<n;j++){
                char c=s.charAt(j);
                if(c=='S'){
                   sx=i;
                    sy=j;
                } else if(c=='E'){
                    ex=i;
                    ey=j;
                } else if(c=='L'){
                    lx=i;
                    ly=j;
                }
                
                map[i][j]=c;
            }
        }
        
        int s1=bfs(sx,sy,lx,ly);
        int s2=bfs(lx,ly,ex,ey);
        
        if(s1==-1 || s2==-1) return -1;
            
        return s1+s2;
    }
    
    int bfs(int startX, int startY, int distX, int distY){
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> q= new LinkedList<>();
        visited[startX][startY]=true;
        q.offer(new int[]{startX,startY,0});
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            int dist=cur[2];
            
            if(cx==distX && cy==distY) return dist;
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                
                if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny]!='X'){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,dist+1});
                }
            }
        }
        
        
        return -1;
    }
}