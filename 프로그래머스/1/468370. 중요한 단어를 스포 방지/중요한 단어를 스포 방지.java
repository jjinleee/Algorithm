import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        StringBuilder sb= new StringBuilder(message);
        for(int[] range : spoiler_ranges){
            for(int i=range[0];i<=range[1];i++){
                if(sb.charAt(i)!=' '){
                    sb.setCharAt(i,'*');
                }
            }
        }
        
        Set<String> set=new HashSet<>();
        for(String m : sb.toString().split(" ")) set.add(m);
        
        for(String b : message.split(" ")){
            if(!set.contains(b)){
                answer++;
                set.add(b);
            }
        }
        return answer;
    }
}