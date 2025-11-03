import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt=0, zero=0;
        
        while(!s.equals("1")){
            int ones=0;
            
            char[] arr=s.toCharArray();
            for(char c : arr){
                if(c=='1') ones++;
            }
            
            zero+=s.length()-ones;
            s=Integer.toBinaryString(ones);
            cnt++;
        }
        return new int[]{cnt,zero};
    }
}