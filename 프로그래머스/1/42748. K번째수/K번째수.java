import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n=commands.length;
        int[] answer =new int[n];
        for(int i=0;i<n;i++){
            int start=commands[i][0]-1;
            int end=commands[i][1];
            int idx=commands[i][2]-1;
            
            int[] arr=Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
            Arrays.sort(arr);
            answer[i]=arr[idx];
        }
        return answer;
    }
}