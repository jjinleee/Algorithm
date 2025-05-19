import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge= new LinkedList<>();
        
        int time=0;
        int total=0;
        int i=0;
        
        
        while(i<truck_weights.length || !bridge.isEmpty()){
            time++;
            
            //다리 다건너면 빼기(현재시간-들어간시간=bridge_length가 되면)
            if(!bridge.isEmpty() && time-bridge.peek()[1]==bridge_length) {
                total-=bridge.poll()[0];
            }
        
            //개수, 무게확인하고 다리에 올라감
            if(i<truck_weights.length && total+truck_weights[i]<=weight){
                bridge.offer(new int[]{truck_weights[i],time});
                total+=truck_weights[i++];
            } 

        }
        
        return time;
    }
}