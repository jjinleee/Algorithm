import java.util.*;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result=new int[commands.length];
        int i=0;
        for(int[] c: commands){
            int[] cut=Arrays.copyOfRange(array,c[0]-1, c[1]);
            Arrays.sort(cut);
            result[i++]=cut[c[2]-1];
        }
        
        return result;
    }
}