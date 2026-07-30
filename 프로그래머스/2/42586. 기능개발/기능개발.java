import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list=new ArrayList<>();
        int n=progresses.length;
        
        //남은 작업일
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            int rest=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
            q.offer(rest);
        }
        
        int finish=0;
        int cnt=1;
        while(!q.isEmpty()){
            int first=q.poll();
            while(!q.isEmpty() && first>=q.peek()){
                q.poll();
                cnt++;
            }
            list.add(cnt);
            cnt=1;
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}