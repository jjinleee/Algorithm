import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s=Integer.toString(n,k); //k진수로 변환

        String num="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='0'){
                //먼저 비어있는지 확인안하면 NumberFormatException 터짐
                if(!num.equals("") && isPrime(num)) answer++;
                num=""; //초기화
            } else num+=c;
        }
        //마지막 덩어리 검사
        if(!num.equals("")){
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    boolean isPrime(String num){
        long n=Long.parseLong(num);
        //System.out.println(n);
        if(n==1) return false;
        if(n==2 || n==3 || n==5 || n==7) return true;
        if(n%2==0 || n%3==0 || n%5==0 || n%7==0) return false;
        for(int i=11;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        
        return true;
    }
}