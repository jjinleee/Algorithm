import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n=board.length;
        
        Stack<Integer> pocket=new Stack<>();
        
        //인형들 저장
        ArrayList<ArrayList<Integer>> dolls= new ArrayList<>();
        for(int i=0;i<n;i++){
            dolls.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                int k=board[j][i];
                if(k!=0) dolls.get(i).add(k);
            }
        }
        
        for(int i=0;i<moves.length;i++){
            int col=moves[i]-1;
            if(dolls.get(col).isEmpty()) continue;
            else if(!pocket.isEmpty() && pocket.peek()==dolls.get(col).get(0)){
                pocket.pop();
                dolls.get(col).remove(0);
                answer+=2;
            }
            else {
                pocket.push(dolls.get(col).get(0));
                dolls.get(col).remove(0);
            }
            
        }
        return answer;
    }
}