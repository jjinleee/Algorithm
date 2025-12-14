import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb= new StringBuilder();
        int num=0;
        while(sb.length()<t*m){
            sb.append(Integer.toString(num++,n));
        }
        
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<t;i++){
            answer.append(Character.toUpperCase(sb.charAt(i*m+p-1)));
        }
        
        return answer.toString();
    }
}