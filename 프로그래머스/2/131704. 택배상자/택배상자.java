import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack=new Stack<>();
        int idx=1; //컨테이너벨트
        int i=0;  //처리할 주문
        int n=order.length;
        
        while(i<n){
            int target=order[i];
            if(idx==target){ //컨테이너벨트에 있음
                idx++;
                i++;
                answer++;
            } else if(!stack.isEmpty() && stack.peek()==target){//보조컨테이너에 있음
                stack.pop();
                i++;
                answer++;
            } else if(idx<=n) stack.push(idx++); //보조 컨테이너에 넣음
            else break; //컨테이너 벨트도 끝났고 보조 컨테이너에도 없음
        }
        
        return answer;
    }
}