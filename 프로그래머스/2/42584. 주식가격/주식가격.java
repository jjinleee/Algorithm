import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n=prices.length;
        int[] answer = new int[n];
        answer[n-1]=0; //마지막은 항상 0
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n-1;i++){
            int cnt=0;
            for(int j=i+1;j<n;j++){
                cnt++;
               if(prices[i]>prices[j]) break;
            }
            answer[i]=cnt;
        }
        
        return answer;
    }
}