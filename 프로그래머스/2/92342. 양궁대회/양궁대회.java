import java.util.*;

class Solution {
    int[] lion=new int[11];
    int[] answer={-1};
    int maxDiff=0;
    
    public int[] solution(int n, int[] info) {
        dfs(0,0,n,info);
        return answer;
    }
    void dfs(int idx, int arrow, int n, int[] info){
        if(idx==11){
            //남은화살처리
            if(arrow<n) lion[10]+=n-arrow;
            checkScore(info);
            if(arrow<n) lion[10]-=n-arrow;
            
            return;
        }
        
        //이김
        int need= info[idx]+1;
        
        if(arrow+need<=n){
            lion[idx]=need;
            dfs(idx+1, arrow+need, n, info);
            lion[idx]=0;
        }
        
        
        //포기
        lion[idx]=0;
        dfs(idx+1, arrow, n, info);
    }
    void checkScore(int[] info){
        int lionScore=0;
        int apeachScore=0;
        
        for(int i=0;i<11;i++){
            if(lion[i]==0 && info[i]==0) continue;
            
            int score=10-i;
            if(lion[i]>info[i]) lionScore+=score;
            else apeachScore+=score;
        }
        
        if(lionScore<=apeachScore) return;
        
        int diff=lionScore-apeachScore;
        
        if(maxDiff<diff){
            maxDiff=diff;
            answer=lion.clone();
        } else if(diff==maxDiff){
            if(isBetter()) answer=lion.clone();
        }
    }
    boolean isBetter(){
        for(int i=10;i>=0;i--){
            if(lion[i]>answer[i]) return true;
            else if(lion[i]<answer[i]) return false;
        }
        
        return false;
    }
    
}