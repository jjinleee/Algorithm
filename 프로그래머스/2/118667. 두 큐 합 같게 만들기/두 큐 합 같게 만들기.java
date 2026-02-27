import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum=0;
        long currentSum=0;
        int answer=0;
        
        for(int q : queue1) {
            sum+=q;
            currentSum+=q;
        }
        for(int q : queue2) sum+=q;

        if(sum%2==1) return -1; //홀수면 불가능
        long target=sum/2;
        
        int n=queue1.length;
        int[] arr=new int[2*n];
        for(int i=0;i<n;i++) arr[i]=queue1[i];
        for(int i=0;i<n;i++) arr[n+i]=queue2[i];
        
        int left=0;
        int right=queue1.length-1;
        while(left<2*n && right<2*n){
            if(currentSum==target) return answer;
            
            if(currentSum<target) {
                if(right+1 >=2*n) break;
                right++;
                currentSum+=arr[right];
                answer++;
            }
            else {
                currentSum-=arr[left];
                left++;
                answer++;
            }
        }
        
        return -1;
    }
}