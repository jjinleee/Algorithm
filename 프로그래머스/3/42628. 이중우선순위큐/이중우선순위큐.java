import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        int n=operations.length;
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            String[] command= operations[i].split(" ");
            
            //숫자 삽입
            if(command[0].equals("I")){
                minHeap.add(Integer.parseInt(command[1]));
                maxHeap.add(Integer.parseInt(command[1]));
                
            } //최솟값 삭제
            else if(!minHeap.isEmpty() && command[0].equals("D") && command[1].equals("-1")){
                int min=minHeap.poll();
                maxHeap.remove(min);
            } //최댓값 삭제
            else if(!minHeap.isEmpty()){
                int max=maxHeap.poll();
                minHeap.remove(max);
            }
        }
        
        if(!minHeap.isEmpty()){
            answer=new int[]{maxHeap.peek(),minHeap.peek()};
        }
        
        return answer;
    }
}