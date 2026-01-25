import java.util.*;

class Solution {
    int maxCount=0;
    int maxSum=0;
    int[] sales={10,20,30,40};
    int[][] gUsers;
    int[] gEmoticons;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] applied=new int[emoticons.length];
        this.gUsers=users;
        this.gEmoticons=emoticons;
        
        dfs(0,applied);
        
        return new int[]{maxCount, maxSum};
    }
    void dfs(int idx, int[] applied){
        if(idx==gEmoticons.length){
            cal(applied);
            return;
        }
        
        for(int s : sales){
            applied[idx]=s;
            dfs(idx+1, applied);
        }
        
    }
    void cal(int[] applied){
        int cnt=0;
        int sum=0;
        
        int m=applied.length;
        for(int[] u : gUsers){
            int total=0;
            for(int i=0;i<m;i++){
                if(applied[i]>=u[0]){ //임티삼
                    total+=gEmoticons[i]*(100-applied[i])/100;
                }
            }
            if(total>=u[1]){ //임플가입
                cnt+=1;
            } else {
                sum+=total; //총합금액
            }
        }
        
        //우선순위 지켜서 갱신
        if(maxCount<cnt){
            maxCount=cnt;
            maxSum=sum;
        } else if(cnt==maxCount && maxSum<sum){
            maxSum=sum;
        }
        
        return;
    }
}