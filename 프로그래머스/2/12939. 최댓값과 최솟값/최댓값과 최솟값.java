import java.util.*;

class Solution {
    public String solution(String s) {
        String[] c=s.split(" ");
        int[] num= new int[c.length];
        int idx=0;
        
        for(String i : c){
            num[idx++]=Integer.parseInt(i);
        }
        Arrays.sort(num);
        
        return num[0]+" "+num[num.length-1];
    }
}