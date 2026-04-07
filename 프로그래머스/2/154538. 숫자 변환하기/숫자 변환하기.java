import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        boolean[] visited=new boolean[y+1];
        Queue<Integer> q= new LinkedList<>();
        q.offer(x);
        visited[x]=true;
        
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                int cur=q.poll();
                if(cur==y) return answer;
                
                int n1=cur+n;
                int n2=cur*2;
                int n3=cur*3;
                
                if(n1<=y && !visited[n1]){
                    visited[n1]=true;
                    q.offer(n1);
                }
                if(n2<=y && !visited[n2]){
                    visited[n2]=true;
                    q.offer(n2);
                }
                if(n3<=y && !visited[n3]){
                    visited[n3]=true;
                    q.offer(n3);
                }
            }
            answer++;
        }
        return -1;
    }
}