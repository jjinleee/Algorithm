import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    int n,m;
    char[][] map;
    public int solution(String[] maps) {
        n=maps.length;
        m=maps[0].length();
        map=new char[n][m];
        
        int[] s=new int[2];
        int[] l=new int[2];
        int[] e=new int[2];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c =maps[i].charAt(j);
                map[i][j]=c;
                if(c=='S') s=new int[]{i,j};
                else if(c=='L') l=new int[]{i,j};
                else if(c=='E') e=new int[]{i,j};
            }
        }
        
        boolean[][] visited=new boolean[n][m];
        int startToLever=bfs(s,l,visited);
        
        visited=new boolean[n][m];
        int leverToExit=bfs(l,e, visited);
        
        if(startToLever==-1 || leverToExit==-1) return -1;
        
        return startToLever+leverToExit;
    }
    int bfs(int[] start, int[] dest, boolean[][] visited){
        visited[start[0]][start[1]]=true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{start[0],start[1],0});
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            
            if(cur[0]==dest[0] && cur[1]==dest[1]) return cur[2];
            
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny]!='X'){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,cur[2]+1});
                }
            }
        }
        return -1;
    }
}