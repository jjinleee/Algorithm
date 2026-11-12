import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int n=cards.length;
        boolean[] visited=new boolean[n+1];
        
        List<Integer> list=new ArrayList<>();
        int total=0;
        
       
        for(int i=0;i<n;i++){
            int sum=0;
            while(!visited[i] && total<=n){
                visited[i]=true;
                i=cards[i]-1;
                sum++;
                total++;
            }
            list.add(sum);
        }
            
        
        
        list.sort(Comparator.reverseOrder());
        
        return list.get(0)*list.get(1);
    }
}