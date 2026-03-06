import java.util.*;

class Solution {
    int answer;
    int[] queen;
    
    public int solution(int n) {
        queen=new int[n];
        backtrack(0,n);
        
        return answer;
    }
    void backtrack(int row, int n){
        if(row==n){
            answer++;
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(row,i)){
                queen[row]=i;
                backtrack(row+1,n);
            }
        }
    }
    boolean isSafe(int row, int col){
        for(int i=0;i<row;i++){
            int prevcol=queen[i];
            if(prevcol==col || Math.abs(prevcol-col)==Math.abs(row-i)){
                return false;
            }
        }
        return true;
    }
}