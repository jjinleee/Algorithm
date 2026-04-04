import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n=commands.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            int[] cut=Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(cut);
            answer[i]=cut[commands[i][2]-1];
        }
        return answer;
    }
}