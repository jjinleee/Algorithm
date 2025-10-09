import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=1;i<=yellow;i++){
            if(yellow%i==0){
                int yx=yellow/i;
                
                if(2*(yx+2)+2*i==brown) return new int[]{yx+2,i+2};
            }
        }
        
        return new int[]{0,0};
    }
}