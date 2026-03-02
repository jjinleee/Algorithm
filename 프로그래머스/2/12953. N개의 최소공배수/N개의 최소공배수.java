import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1;i<arr.length;i++){
            answer=lcm(arr[i],answer);
        }
        
        return answer;
    }
    int lcm(int a, int b){
        return a*b/gcd(b,a);
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