import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        //yellow의 개수 경우의 수를 모두 탐색해 brown 개수가 되는것 찾음
        for(int i=1;i<=Math.sqrt(yellow);i++){
            if(yellow%i!=0) continue; //정확히 나눠떨어지지않는건 건너뛰어야 하는 조건!!
            int w=i;
            int h=yellow/i;
            if((w+2)*(h+2)-w*h==brown){
                return w>=h ? new int[]{w+2,h+2} : new int[]{h+2,w+2};
            }
        }
        
        return new int[]{0,0};
    }
}