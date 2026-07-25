import java.util.*;

class Solution {
    int maxCount=0;
    int maxSum=0;
    int[] discount={10,20,30,40};
    int[][] gusers;
    int[] gemoticons;
    public int[] solution(int[][] users, int[] emoticons) {
        this.gusers=users;
        this.gemoticons=emoticons;
    
        int[] selected=new int[emoticons.length];
        dfs(0,selected);
        
        return new int[]{maxCount, maxSum};
    }
    void dfs(int idx, int[] selected ){
        if(idx==gemoticons.length){
            //사용자구매결과 계산
            cal(selected);
            return;
        }
        for(int rate : discount){
            selected[idx]=rate;
            dfs(idx+1, selected);
        }
    }
    void cal(int[] selected){
        int[] money=new int[gusers.length];
        int join=0;
        
        for(int i=0;i<gusers.length;i++){
            int ratio=gusers[i][0];
            int limit=gusers[i][1];
            
            for(int j=0;j<selected.length;j++){
                if(selected[j]>=ratio) money[i]+=(gemoticons[j]*(100-selected[j])/100);
            }
            if(money[i]>=limit){
                join++;
                money[i]=0;
            }
        }
        
        int sum=0;
        for(int m : money) sum+=m; //총판매액
        
        if(maxCount<join){
            maxCount=join;
            maxSum=sum;
        } else if(maxCount==join && maxSum<sum){
            maxCount=join;
            maxSum=sum;
        } 
    }
}