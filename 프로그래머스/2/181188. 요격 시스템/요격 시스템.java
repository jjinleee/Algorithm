import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a,b)->a[1]-b[1]);
        int point=-1;
        for(int[] t : targets){
            if(t[0]>=point){
                answer++;
                point=t[1];
            }
        }
        
        return answer;
    }
}