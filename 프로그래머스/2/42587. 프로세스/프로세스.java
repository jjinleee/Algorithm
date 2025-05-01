import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n=priorities.length;
        
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            //우선순위, 인덱스 저장
            queue.add(new int[]{priorities[i],i});
        }
        
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            boolean high=false;
            
            for(int[] p:queue){
                if(p[0]>cur[0]){    //큐안에 우선순위가 더높은게있는지확인
                    high=true;
                    break;
                }
            }
            
            if(high){ //있으면 큐에 다시 넣기
                queue.add(cur);
            } else{
                answer++; 
                if(cur[1]==location) return answer; //없고 찾는 location이면 return
            }
        }
        return -1;
    }
}