import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n=progresses.length;
        int[] day=new int[n];
        for(int i=0;i<n;i++){
            day[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        List<Integer> list=new ArrayList<>();
        Deque<Integer> q=new ArrayDeque<>();
        for(int d : day){
            if(!q.isEmpty() && q.peekFirst()<d){
                list.add(q.size());
                q.clear();
                q.offer(d);
            } else{
                q.offerLast(d);
            }
        }
        list.add(q.size());
        
        return list.stream().mapToInt(i->i).toArray();
    }
}