import java.util.*;

class Solution {
    int[] start={0,0};
    int[] rever={0,0};
    int[] exit={0,0};
    char[][] map;
    int n,m;
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int solution(String[] maps) {
        int answer = 0;
        n=maps.length;
        m=maps[0].length();
        map=new char[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=maps[i].charAt(j);
                //각 위치 저장
                if(map[i][j]=='S') start=new int[]{i,j};
                if(map[i][j]=='L') rever=new int[]{i,j};
                if(map[i][j]=='E') exit=new int[]{i,j};
            }
        }
        //출발->레버
        int startToLever=bfs(start[0],start[1], rever[0],rever[1]);
        int LeverToExit=bfs(rever[0],rever[1],exit[0],exit[1]);
        
        
        return (startToLever==-1 || LeverToExit==-1) ? -1 : (startToLever+LeverToExit);
    }
    int bfs(int startx, int starty, int targetx, int targety){
        if(startx==targetx && starty==targety) return 0;
        
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{startx,starty,0});
        visited[startx][starty]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0],y=cur[1],dist=cur[2];
            
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m &&map[nx][ny]!='X' &&!visited[nx][ny]){
                    if(nx==targetx && ny==targety) return dist+1;
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,dist+1});
                }
            }
        } 
        
        return -1;
    }
}