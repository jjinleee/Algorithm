import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int total=0;
        int index=0;
        
        Queue<Integer> bridge=new LinkedList<>();
        //0으로채워넣음
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        
        while(index<truck_weights.length){
            time++;
            
            //무조건 시간 지남에 따라 흐름
            total-=bridge.poll();
            //무게 안넘으면 넣음
            if(total+truck_weights[index]<=weight){
                bridge.offer(truck_weights[index]);
                total+=truck_weights[index++];
            } else bridge.offer(0); //못넣으면 0을 넣음
        }
        //마지막 트럭 빠져나오는 시간
        time+=bridge_length;
        
        return time;
    }
}