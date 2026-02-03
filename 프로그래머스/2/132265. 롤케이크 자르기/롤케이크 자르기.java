import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int max=0;
        for(int t : topping){
            if(t>max) max=t;
        }
        
        int[] left=new int[max+1];
        int[] right=new int[max+1];
        
        int leftKind=0;
        int rightKind=0;
        //동생에게 다넣음
        for(int t: topping){
            if(right[t]==0){
                rightKind++;
            }
            right[t]++;
        }
        
        for(int i=0;i<topping.length-1;i++){ //맨마지막은 못자름
            //하나씩 잘라
            int t=topping[i];
            right[t]--;
            
            if(right[t]==0){
                rightKind--;
            }
            
            if(left[t]==0) leftKind++;
            left[t]++;
            
            if(leftKind==rightKind) answer++;
        }
        
        return answer;
    }
}