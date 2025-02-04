import java.util.*;

class Solution {
    private int cnt=0;
    private int[] queens;
    
    public int solution(int n) {
        queens=new int[n];
        backtrack(0,n);
        return cnt;
    }
    private void backtrack(int row,int n){
        if(row==n){
            cnt++;
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col)){
                queens[row]=col;
                backtrack(row+1,n);
            }
        }
    }
    private boolean isSafe(int row,int col){
        for(int prevrow=0;prevrow<row;prevrow++){
            int prevcol=queens[prevrow];
            if(prevcol==col || Math.abs(prevcol-col)==Math.abs(prevrow-row)){
                return false;
            }
        }
        return true;
    }
}