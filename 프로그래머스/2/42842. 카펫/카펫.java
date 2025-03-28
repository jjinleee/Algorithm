import java.util.*;
class Solution {
    List<int[]> y=new ArrayList<>();
    
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        //yellow 가로 세로 조합
        for(int i=1;i*i<=yellow;i++){
            if(yellow%i==0) y.add(new int[]{yellow/i,i});
        }
        
        //brown길이 확인
        for(int[] length:y){
            int x=length[0]+2;
            int y=length[1];
            
            if(2*x+2*y==brown){
                return new int[]{x,y+2};
            }
        }
        
        return answer;
    }
}