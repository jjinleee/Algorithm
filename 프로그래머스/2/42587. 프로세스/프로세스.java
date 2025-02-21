import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<Process> q= new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        
        for(int i=0;i<priorities.length;i++){
            q.offer(new Process(priorities[i],i));
            list.add(priorities[i]);
        }
        list.sort(Collections.reverseOrder());

        int order=0;
        
        while(!q.isEmpty()){
            Process current=q.poll();
            
            if(current.priority==list.get(0)){
                order++;
                list.remove(0);
                
                if(current.index==location){
                    return order;
                }
            } else q.offer(current);
        }
        
        
        return -1;
    }
    static class Process{
        int priority;
        int index;
        
        public Process(int priority, int index){
            this.priority=priority;
            this.index=index;
        }
    }
}