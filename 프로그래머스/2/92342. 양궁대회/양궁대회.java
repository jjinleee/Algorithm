import java.util.*;

class Solution {
    int[] lion=new int[11];
    int[] answer={-1};
    int maxDiff=0;
    
    public int[] solution(int n, int[] info) {
        dfs(0,0,n,info);
        return answer;
    }
    void dfs(int idx, int used, int n, int[] info){
        //모두확인한경우
        if(idx==11){
            //남은화살은 0점에
            if(used<n) lion[10]+=n-used;
            
            checkScore(info);
            
            if(used<n) lion[10]-=n-used; //원상복구
            
            return;
        }
        
        int need=info[idx]+1; //현재점수를 이기기 위한 화살수
        
        //이김
        if(used+need<=n){
            lion[idx]=need;
            dfs(idx+1, used+need,n,info);
            lion[idx]=0;
        }
        
        //포기
        lion[idx]=0;
        dfs(idx+1, used,n,info);
    }
    void checkScore(int[] info){
        int apeachScore=0;
        int lionScore=0;
        
        for(int i=0;i<11;i++){
            if(info[i]==0 && lion[i]==0) continue;
            
            int score=10-i;
            
            if(lion[i]>info[i]) lionScore+=score;
            else apeachScore+=score;
        }
        
        int diff=lionScore-apeachScore;
        
        if(diff<=0) return; //라이언이 짐
        
        if(diff>maxDiff){
            maxDiff=diff;
            answer=lion.clone();
        } else if(diff==maxDiff){
            if(isBetter()) answer=lion.clone();
        }
    }
    boolean isBetter(){
        for(int i=10;i>=0 ;i--){
            if(lion[i]>answer[i]) return true;
            else if(lion[i]<answer[i]) return false;
        }
        
        return false;
    }
}