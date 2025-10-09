import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int n=sizes.length;
        int[] w= new int[n];
        int[] h= new int[n];
        
        int i=0;
        for(int[] s : sizes){
            Arrays.sort(s);
            w[i]=s[0];
            h[i++]=s[1];
        }
        Arrays.sort(w);
        Arrays.sort(h);
        
    
        return w[n-1]*h[n-1];
    }
}