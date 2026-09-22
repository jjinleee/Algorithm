import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1] );
        
        int need=-1;
        for(int[] t : targets){
            int start=t[0];
            int end=t[1];
            
            if(start>=need){
                answer++;
                need=end;
            }
        }
        return answer;
    }
}