import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n=board.length;
        Stack<Integer> pick=new Stack<>();
        //박스를 세로로 담고싶음
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++) list.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[j][i]!=0) list.get(i).add(board[j][i]);
            }
        }
        
        for(int m : moves){
            if(!list.get(m-1).isEmpty()){
                int p=list.get(m-1).get(0);
                if(!pick.isEmpty() && pick.peek()==p){
                    pick.pop();
                    answer+=2;
                } else pick.push(p);
                list.get(m-1).remove(0);
            }
        }
        
        return answer;
    }
}