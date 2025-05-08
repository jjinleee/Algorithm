import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        //yellow가 되는 경우의 수(1부터 시작했으니까 [1]이 더김->가로가됨)
        List<int[]> wh=new ArrayList<>();
        for(int i=1;i<=Math.sqrt(yellow);i++){
            if(yellow%i==0){
                wh.add(new int[]{i,yellow/i});
            }
        }
        
        for(int[] t: wh){
            int bw=(t[1]+2);
            int bh=2+t[0];
            if(2*bw+2*bh-4==brown){
                return new int[]{bw,bh};
            }
        }
        return answer;
    }
}