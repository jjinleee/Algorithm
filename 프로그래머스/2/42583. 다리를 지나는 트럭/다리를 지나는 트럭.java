import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge=new LinkedList<>();
        int curWeight=0;
        int cnt=0;
        int time=0;
        
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        
        while(cnt<truck_weights.length){
            time++;
            
            curWeight-=bridge.poll();
            if(curWeight+truck_weights[cnt]<=weight){
                bridge.offer(truck_weights[cnt]);
                curWeight+=truck_weights[cnt++];
            } else bridge.offer(0);
            
        }
        time+=bridge_length;
        
        return time;
    }
}