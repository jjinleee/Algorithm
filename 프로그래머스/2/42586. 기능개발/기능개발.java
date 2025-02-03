import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer= new ArrayDeque<>();
        int n=progresses.length;
        
        int[] days=new int[n];
        for(int i=0;i<n;i++){
            days[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        int cnt=1;
        int maxday=days[0];
        
        for(int i=1;i<n;i++){
            if(days[i]<=maxday) cnt++;
            else{
                answer.add(cnt);
                cnt=1;
                maxday=days[i];
            }
        }
        
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}