import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth=0;
        int maxHeight=0;
        
        //더 긴걸 세로로 놓기
        for(int[] s : sizes){
            if(s[0]<=s[1]){
                if(s[0]>maxWidth) maxWidth=s[0];
                if(s[1]>maxHeight) maxHeight=s[1];
            } else {
                if(s[1]>maxWidth) maxWidth=s[1];
                if(s[0]>maxHeight) maxHeight=s[0];
            }
        }
        
        
        return maxHeight*maxWidth;
    }
}