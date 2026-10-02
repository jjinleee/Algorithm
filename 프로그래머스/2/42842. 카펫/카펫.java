import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int x=1;x<=yellow;x++){ //세로
            if(yellow%x!=0) continue;
            int y=yellow/x; //가로
            
            if(2*y+2*(x+2)==brown) return new int[]{y+2,x+2};
            
        }
        return new int[]{0,0};
    }
}