import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //트럭무게, 다리진입시간 넣음
        Queue<int[]> bridge= new LinkedList<>();
        
        int total=0;
        int i=0;
        int time=0;
        
        //트럭이 모두 지나갈때까지
        while(i<truck_weights.length || !bridge.isEmpty()){
            time++;
            
            //다 지난 트럭 큐에서제거
            if(!bridge.isEmpty() && time-bridge.peek()[1]>=bridge_length){
                total-=bridge.poll()[0];
            }
            
            //무게와 개수 체크해서 다리 진입
            if(i < truck_weights.length && total+truck_weights[i]<= weight){
                bridge.offer(new int[]{truck_weights[i],time });
                total+=truck_weights[i++];
            }
        }
        return time;
    }
}