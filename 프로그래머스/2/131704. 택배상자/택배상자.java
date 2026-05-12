import java.util.*;

class Solution {
    public int solution(int[] order) {
        int n = order.length;
        int i=0;
        int num=1; //현재순서
        
        Stack<Integer> sub= new Stack<>();
        while(num<=n){
            if(num==order[i]){
                i++;
                num++;
            } else if(!sub.isEmpty() && sub.peek()==order[i]){
                sub.pop();
                i++;
            } else {
                sub.push(num);
                num++;
            }
        }
        
        //마지막처리
        while(!sub.isEmpty()){
            if(sub.peek()==order[i]) {
                i++;
                sub.pop();
            }
            else break;
        }
        
        
        
                
        return i;
    }
}