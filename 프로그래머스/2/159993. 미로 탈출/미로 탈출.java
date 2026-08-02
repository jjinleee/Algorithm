import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    int n,m;
    int sx,sy,lx,ly,ex,ey;
    char[][] map;
    public int solution(String[] maps) {
        int sum = 0;
        n=maps.length;
        m=maps[0].length();
        map=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=maps[i].charAt(j);
                if(map[i][j]=='S'){
                    sx=i; sy=j;
                } else if(map[i][j]=='E'){
                    ex=i; ey=j;
                } else if(map[i][j]=='L'){
                    lx=i; ly=j;
                }
            }
        }
        
        int toLever=bfs(sx,sy,lx,ly);
        if(toLever==-1) return -1;
        
        int toExit=bfs(lx,ly,ex,ey);
        if(toExit==-1) return -1;
        
        return toLever+toExit;
    }
    int bfs(int sx, int sy, int ex, int ey){
        int sum=0;
        
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{sx,sy,0});
        visited[sx][sy]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            int distance=cur[2];
            
            if(cx==ex && cy==ey){
                return distance;
            }
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny]!='X'){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,distance+1});
                }
            }
        }
        
        return -1;
    }
}