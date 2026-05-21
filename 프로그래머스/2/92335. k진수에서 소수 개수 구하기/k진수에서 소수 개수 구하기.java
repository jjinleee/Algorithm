import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String tmp=Integer.toString(n,k);
        
        StringBuilder sb=new StringBuilder();
        for(char c : tmp.toCharArray()){
            if(c=='0' && sb.length()!=0){
                if(isPrime(sb.toString())) answer++;
                sb.setLength(0);
            } else{
                sb.append(c);
            }
        }
        
        //마지막 처리
        if(sb.length()!=0 && isPrime(sb.toString())) answer++;
        
        return answer;
    }
    boolean isPrime(String num){
        long n=Long.parseLong(num);
        
        if(n==1) return false;
        if(n==2 || n==3 ||n==5) return true;
        if(n%2==0 || n%3==0) return false;
        
        for(long i=5;i*i<=n;i++){
            if(n%i==0) return false;
        }
        
        return true;
    }
} 