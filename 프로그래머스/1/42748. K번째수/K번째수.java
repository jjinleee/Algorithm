import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int n=commands.length;
        answer=new int[n];
        
        int a=0;
        for(int[] c:commands){
            int i=c[0];
            int j=c[1];
            int k=c[2];
            
            int[] copy=Arrays.copyOfRange(array, i-1,j);
            Arrays.sort(copy);
            answer[a++]=copy[k-1];
        }
        
        return answer;
    }
}