import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int index=0;
        int[] answer=new int[commands.length];
        for(int[] c : commands){
            int i=c[0];
            int j=c[1];
            int k=c[2];
            
            int[] sub=Arrays.copyOfRange(array,i-1,j);
            System.out.println(sub[0]);
            Arrays.sort(sub); 
            answer[index++]=sub[k-1];
        } 
        
        return answer;
    }
}