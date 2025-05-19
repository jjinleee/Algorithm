import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.offer(new int[]{i,priorities[i]});
        }
        
        int order=1;
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            
            // 뒤에 더 높은 우선순위가 있는지 확인 stream, anyMatch 사용
            boolean hasHigher = queue.stream().anyMatch(p -> p[1] > current[1]);
            
            if(hasHigher){
                queue.offer(current); //맨뒤로보냄
            } else{
                if(current[0]==location){ //location 차례가 오면 해당 order return
                    return order;
                } 
                order++;
            }
        }
        
        return 0;
    }
}