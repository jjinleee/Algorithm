import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n=board.length;
        
        Stack<Integer> pocket=new Stack<>();
        
        for(int move:moves){
            int col=move-1;
            
            for(int row=0;row<n;row++){
                if(board[row][col]!=0){
                    int doll=board[row][col];
                    board[row][col]=0;
                    
                    if(!pocket.isEmpty() && pocket.peek()==doll){
                        pocket.pop();
                        answer+=2;
                    } else pocket.push(doll);
                    break;
                } 
            }
        }
        return answer;
    }
}