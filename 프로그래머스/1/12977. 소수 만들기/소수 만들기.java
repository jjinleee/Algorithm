import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(isPrime(sum)) answer++;
                }
            }
        }
        return answer;
    }
    
    boolean isPrime(int n){
        if(n<2) return false;
        if(n==2 || n==3 || n==5) return true;
        if(n%2==0 || n%3==0 || n%5==0) return false;
        for(int i=7;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}