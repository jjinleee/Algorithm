import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge=new LinkedList<>();
        int time=0;
        int totalWeight=0;
        
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        
        for(int truck:truck_weights){
            while(true){
                totalWeight-=bridge.poll();
                
                if(totalWeight+truck<=weight){
                    bridge.offer(truck);
                    totalWeight+=truck;
                    time++;
                    break;
                } else {
                    bridge.offer(0);
                    time++;
                }
            }
        }
        return time+bridge_length;
    }
}