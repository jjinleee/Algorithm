import java.util.*;

class Solution {
    char[][] map;
    int h,w;
    public int[] solution(String[] park, String[] routes) {
        h=park.length;
        w=park[0].length();
        map=new char[h][w];
        
        int x=0;
        int y=0;
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                char c=park[i].charAt(j);
                map[i][j]=c;
                if(c=='S'){
                    x=i;
                    y=j;
                }
                
            }
        }
        
        for(String r : routes){
            String[] tmp=r.split(" ");
            char dir=tmp[0].charAt(0);
            int n=Integer.parseInt(tmp[1]);
            
            if(dir=='S'){ //남
               if(x+n<h && isObstacle(x,y,n,dir)){
                  x+=n;
               } 
            } else if(dir=='N'){ //북
               if(x-n>=0  &&  isObstacle(x,y,n,dir)){
                  x-=n;
               }         
            } else if(dir=='W'){ //서
               if( y-n>=0 &&  isObstacle(x,y,n,dir)){
                  y-=n;
               } else continue;                
            } else { //동
               if(y+n<w &&  isObstacle(x,y,n,dir)){
                  y+=n;
               } else continue;                
            }
        }
        
        
        return new int[]{x,y};
    }
    boolean isObstacle(int x,int y, int n, char dir){
        if(dir=='E'){
            for(int i=1;i<=n;i++){
                if(map[x][y+i]=='X') return false;
            }
            
        }else if(dir=='W'){
            for(int i=1;i<=n;i++){
                if(map[x][y-i]=='X') return false;
            }            
        }else if(dir=='N'){
            for(int i=1;i<=n;i++){
                if(map[x-i][y]=='X') return false;
            }            
        }else {
            for(int i=1;i<=n;i++){
                if(map[x+i][y]=='X') return false;
            }            
        }
        
        return true;
    }
}