import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack=new Stack<>();
        
        for(int a : arr){
            if(!stack.isEmpty() && stack.peek()==a) continue;
            stack.add(a); 
        }
        
        int[] result=stack.stream().mapToInt(i->i).toArray();
       
        return result;
    }
}