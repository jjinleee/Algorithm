import java.util.*;

class Solution {
    char[][] map=new char[3][3];
    public int solution(String[] board) {
        int answer = -1;
        int a=0;
        int b=0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                map[i][j]=board[i].charAt(j);
                if(map[i][j]=='O') a++;
                else if(map[i][j]=='X') b++;
            }
        }
        
        if(a-b>=2 || a<b)  return 0;
        
        boolean aWin=winner('O');
        boolean bWin=winner('X');
        
        if(aWin && a==b) return 0;
        if(bWin && a-1==b) return 0;

        
        return 1;
    }
    boolean winner(char c){
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