import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x=0, y=0;
        int n=park.length;
        int m=park[0].length();
        
        char[][] map=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=park[i].charAt(j);
                if(map[i][j]=='S'){
                    x=i;
                    y=j;
                }
            }
        }
        
        for(String r  : routes){
            String[] tmp=r.split(" ");
            char dir=tmp[0].charAt(0);
            int t=Integer.parseInt(tmp[1]);
            
            int nx=x;
            int ny=y;
            boolean canMove=true;
            
            for(int i=0;i<t;i++){
              if(dir=='N') nx--; 
                else if(dir=='S') nx++;
                else if(dir=='E') ny++;
                else ny--;
                
                if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny]=='X'){
                    canMove=false;
                    break;
                }
            }
            if(canMove){
                x=nx;
                y=ny;
            }
        }
        
        return new int[]{x,y};
    }
}