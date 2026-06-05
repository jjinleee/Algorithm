import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n=prices.length;
        if(n==1) return new int[]{0};
        
        int[] answer = new int[n];
        for(int i=0;i<n-1;i++){
            int cnt=0;
            for(int j=i+1;j<n;j++){
                cnt++;
                if(prices[i]>prices[j]) break;
            }
            answer[i]=cnt;
            
        }
        answer[n-1]=0; //마지막 원소
        
        return answer;
    }
}