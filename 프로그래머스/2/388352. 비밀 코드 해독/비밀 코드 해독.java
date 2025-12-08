import java.util.*;

class Solution {
    int n;
    int[][] Q;
    int[] Ans;
    int m;
    int answer=0;
    int[] pick=new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n=n;
        this.Q=q;
        this.Ans=ans;
        this.m=q.length;
        
        dfs(1,0);
        
        return answer;
    }
    void dfs(int start,int depth){
        if(depth==5){
            if(isValid()){
                answer++;
            }
            return;
        }
        
        for(int i=start;i<=n;i++){
            pick[depth]=i;
            dfs(i+1,depth+1);
        }
    }
    boolean isValid(){
        for(int i=0;i<m;i++){
            int cnt=0;
            
            for(int j=0;j<5;j++){
                int val=Q[i][j];
                for(int t=0;t<5;t++){
                    if(pick[t]==val){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt!=Ans[i]) return false;
        }
        return true;
    }
}