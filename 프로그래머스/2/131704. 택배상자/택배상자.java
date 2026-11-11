import java.util.*;
                                                                            
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n=order.length;
        int i=0;
        int main=1;
        Stack<Integer> sub=new Stack<>();
        
        while(i<n){
            if(!sub.isEmpty() && sub.peek()==order[i]){
                sub.pop();
                i++;
                answer++;
            } else if(main<=n && main==order[i]){ //메인
                i++;
                answer++;
                main++;
            } else if(main<=n) {
                sub.push(main);
                main++;   
            } else break;  
        }
        return answer;
    }
}