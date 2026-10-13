import java.util.*;

class Solution {
    char[][] map;
    int n;
    int m;
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int solution(String[] maps) {
        n=maps.length;
        m=maps[0].length();
        map=new char[n][m];
        
        int[] start=new int[2];
        int[] lever=new int[2];
        int[] exit=new int[2];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=maps[i].charAt(j);
                if(map[i][j]=='S'){
                    start[0]=i;
                    start[1]=j;
                } else if(map[i][j]=='L'){
                    lever[0]=i;
                    lever[1]=j;
                } else if(map[i][j]=='E'){
                    exit[0]=i;
                    exit[1]=j;
                }
            }
        }
        
        int first=bfs(start[0],start[1], lever[0],lever[1]);
        int second=bfs(lever[0],lever[1], exit[0], exit[1]);

        if(first==-1 || second==-1) return -1;
        
        return first+second;
    }
    int bfs(int sx,int sy, int ex, int ey){
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{sx,sy,0});
        visited[sx][sy]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int dist=cur[2];

            if(cur[0]==ex && cur[1]==ey) return dist;
            
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny]!='X'){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,dist+1});
                }
            }
        }
        
        return -1;
    }
}