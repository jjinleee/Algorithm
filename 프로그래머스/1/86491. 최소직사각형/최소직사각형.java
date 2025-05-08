import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        //가로세로 오름차순 정렬
        for(int s[]:sizes){
            Arrays.sort(s);
        }
        int n=sizes.length;
        
        int[] width=new int[n];
        int[] height=new int[n];

        for(int i=0;i<n;i++){
            width[i]=sizes[i][0];
            height[i]=sizes[i][1];
        }
        Arrays.sort(width);
        Arrays.sort(height);
        
        
        return width[n-1]*height[n-1];
    }
}