import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<t*m;i++){
            String tmp=Integer.toString(i,n).toUpperCase();
            sb.append(tmp);
        }
        
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<t;i++){
            answer.append(sb.charAt(p+m*i-1));
        }
        
        
        return answer.toString();
    }
}