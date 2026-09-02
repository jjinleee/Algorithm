import java.util.*;

class Solution {
    char[][] map;
    public int solution(String[] board) {
        int o=0;
        int x=0;
        
        map=new char[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char tmp=board[i].charAt(j);
                if(tmp=='O') o++;
                else if(tmp=='X') x++;
                map[i][j]=tmp;
            }
        }
        //개수 틀림
        if(o<x) return 0;
        if(o>x+1) return 0;
        
        boolean owin=win('O');
        boolean xwin=win('X');
        
        //이미 승패났는데 진행
        if(owin && xwin) return 0;
        if(owin && o!=x+1) return 0;
        if(xwin && o!=x) return 0;
        
        return 1;
        
    }
    boolean win(char c){ 
        //좌우대각선
        for(int i=0;i<3;i++){
            if(map[i][0]==c && map[i][1]==c && map[i][2]==c) return true;
            
        }
        
        for(int j=0;j<3;j++){
            if(map[0][j]==c && map[1][j]==c && map[2][j]==c) return true;
        }
        
        if(map[0][0]==c && map[1][1]==c && map[2][2]==c) return true;
        
        if(map[0][2]==c && map[1][1]==c && map[2][0]==c) return true;
        
        return false;
        
    }
}