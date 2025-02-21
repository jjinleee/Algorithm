import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> nums= new ArrayList<>();
        
        nums.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]) {
                nums.add(arr[i]);
            }
        }
    
        answer=nums.stream().mapToInt(i->i).toArray();

        return answer;
    }
}