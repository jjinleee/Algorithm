import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        for(String o:operations){
            String[] command=o.split(" ");
            if(command[0].equals("I")){
                min.add(Integer.parseInt(command[1]));
                max.add(Integer.parseInt(command[1]));
            }
            else if(command[1].equals("1")){ //최댓값삭제
                min.remove(max.poll());
            } else { //최솟값삭제
                max.remove(min.poll());
            }
        }
        
        return min.isEmpty() ? new int[]{0,0} : new int[]{max.peek(),min.peek()};
    }
}