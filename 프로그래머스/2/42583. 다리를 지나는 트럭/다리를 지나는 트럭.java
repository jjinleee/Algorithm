import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<int[]> queue=new LinkedList<>(); //트럭무게,다리진입시간
        int time=0;
        int totalWeight=0;
        int index=0; //다음에올라갈 트럭 인덱스
        
        while(index<truck_weights.length || !queue.isEmpty()){
            time++;
            
            //다리를 다 건넜으면 제거
            if(!queue.isEmpty() && time-queue.peek()[1]>=bridge_length){
                totalWeight-=queue.poll()[0];
            }
            
            //다음트럭이 올라올수있으면 올림
            if(index<truck_weights.length && totalWeight + truck_weights[index]<=weight){
                queue.offer(new int[]{truck_weights[index],time});
                totalWeight+=truck_weights[index];
                index++;
            }
        }
        
        return time;
        
        
    }
}