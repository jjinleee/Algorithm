import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n=commands.length;
        int[] answer = new int[n];
        
        for(int i=0;i<n;i++){
            int start=commands[i][0]-1;
            int end=commands[i][1];
            int index=commands[i][2]-1;
            
            int[] temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp);
            answer[i] = temp[index];
        }
        return answer;
    }
}