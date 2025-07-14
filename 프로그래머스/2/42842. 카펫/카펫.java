import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int i=1;i<=yellow;i++){
            if(yellow%i==0){
                int yx=i;
                int yy=yellow/i; 
                
                if(2*(yx+2) + 2*yy==brown) {
                    return yx>=yy ?new int[]{yx+2, yy+2} : new int[]{yy+2,yx+2};
                }
            }

        }
        return new int[]{0,0};
    }
}