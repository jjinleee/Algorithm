import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int time = 0;
        int n=signals.length;
        int[] sum=new int[n];
        for(int i=0;i<n;i++){
            sum[i]+=signals[i][0]+signals[i][1]+signals[i][2];
        }
        Arrays.sort(sum);
        
        //주기 최소공배수
        int l=sum[0];
        for(int i=1;i<n;i++){
            l=lcm(l,sum[i]);
        }
        
        
        for(int t=1;t<=l;t++){
            boolean ok=true;
            
            for(int i=0;i<n;i++){
                int p=signals[i][0]+signals[i][1]+signals[i][2];
                int pos=(t-1)%p;
                
                if(!(pos>=signals[i][0] && pos<signals[i][0]+signals[i][1])){
                    ok=false;
                    break;
                }
            }
            if(ok) return t;
        }
        
        return -1;
    }
    int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
    int gcd(int a, int b){
        while(b!=0){
            int tmp=a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
}