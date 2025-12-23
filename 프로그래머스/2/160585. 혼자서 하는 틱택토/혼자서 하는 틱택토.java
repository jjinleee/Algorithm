import java.util.*;

class Solution {
    public int solution(String[] board) {
        int f = 0;
        int s = 0;
        
        boolean firstWin=isFinish(board, 'O');
        boolean secondWin=isFinish(board,'X');
        
        //순서 오류-> O-X=1 or 0
        for(String b : board){
            for(char c : b.toCharArray()){
                //각 개수 세기
                if(c=='O') f++;
                else if(c=='X') s++;
            }
        }
        //개수비교
        if(f-s!=0 && f-s!=1) return 0;
        if(f==s && firstWin) return 0;//선공 승리후에도 진행
        if(f-s==1 && secondWin) return 0; //후공 승리후에도 진행 
        
        return 1;
    }
    boolean isFinish(String[] board, char mark){
        //가로체크
        for(int i=0;i<3;i++){
            String s=board[i];
            if(s.charAt(0)==mark && s.charAt(1)==mark && s.charAt(2)==mark) return true;
        }
        //ㅅㅔ로체크
        for(int i=0;i<3;i++){
            if(board[0].charAt(i)==mark && board[1].charAt(i)==mark && board[2].charAt(i)==mark) return true;
        }
        //대각선체크
        if(board[0].charAt(0)==mark && board[1].charAt(1)==mark && board[2].charAt(2)==mark) return true;
        if(board[0].charAt(2)==mark && board[1].charAt(1)==mark && board[2].charAt(0)==mark) return true;
        
        return false;
    }
}