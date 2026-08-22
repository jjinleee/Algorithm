import java.util.*;

class Solution {
    public int solution(int n) {
        int two=0;
        String tmp=Integer.toString(n,2);
        for(char c : tmp.toCharArray()){
            if(c=='1') two++;
        }
        while(true){
            n++;
            int cnt=0;
            String can=Integer.toString(n,2);
            for(char c : can.toCharArray()){
                if(c=='1') cnt++;
            }
            if(cnt==two) {
                return n;
            }
        }
        
        
    }
}