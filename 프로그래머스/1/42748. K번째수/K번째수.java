import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result=new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int start=commands[i][0];
            int end=commands[i][1];
            int index=commands[i][2];
            
            int[] temp=Arrays.copyOfRange(array,start-1, end);
            Arrays.sort(temp);
            
            result[i]=temp[index-1];
            
        }
        return result;
    }
}