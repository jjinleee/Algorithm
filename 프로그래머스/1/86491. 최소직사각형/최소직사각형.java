import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        //가로,세로 각 명함 별 정렬
        int[] w=new int[sizes.length];
        int[] h=new int[sizes.length];
        
        int i=0;
        for(int[] s : sizes){
            Arrays.sort(s);
            w[i]=s[0];
            h[i]=s[1];
            i++;
        }
        
        Arrays.sort(w);
        Arrays.sort(h);
        
        //각 열에서 가장 큰 것 뽑아서 w*h return
        return w[sizes.length-1]*h[sizes.length-1];
    }
}