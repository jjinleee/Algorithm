import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack=new Stack<>(); //보조컨테이너
        int idx=0; //현재실어야하는 상자 인덱스
        int n=order.length;
        for(int i=1;i<=n;i++){
            //메인컨테이너에 있음
           if(i==order[idx]) {
               answer++;
               idx++;
           } else {
               //보조컨테이너에 있음
                if(!stack.isEmpty() && stack.peek()==order[idx]){
                    stack.pop();
                    idx++;
                    answer++;  
                } else stack.push(i); //보조에 넣어놓음 
            }
            while(!stack.isEmpty()){
                if(order[idx]==stack.peek()){
                    answer++;
                    idx++;
                    stack.pop();
                } else break;
            }
            if(idx==n) break;
        }
        
        return answer;
    }
}