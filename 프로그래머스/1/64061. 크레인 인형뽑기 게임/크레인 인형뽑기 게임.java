import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int row=board.length;
        int col=board[0].length;
        
        Stack<Integer> stack=new Stack<>(); //내가뽑은인형쌓음
        for(int i=0;i<moves.length;i++){
            int pickCol=moves[i]-1; //뽑을열
            for(int j=0;j<row;j++){
                int num=board[j][pickCol];
                //0이 아니면 뽑고 0으로 변경
                if(num!=0){
                    //같으면 터뜨림
                    if(!stack.isEmpty() && stack.peek()==num) {                   
                        stack.pop();
                        answer+=2;
                    } else stack.push(num);
                    
                    //뽑은건 0으로 변경
                    board[j][pickCol]=0;
                    break; //하나뽑았으면 그만
                }
            }    
        }
        
        return answer;
    }
}