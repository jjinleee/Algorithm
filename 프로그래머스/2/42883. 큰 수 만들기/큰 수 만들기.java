import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer= new StringBuilder();
        
        for(int i=0;i<number.length();i++){
            char c =number.charAt(i);
            //새로넣으려는 숫자가 더 크면 삭제하기 
            while(k>0 && answer.length()>0 && answer.charAt(answer.length()-1)<c){
               answer.deleteCharAt(answer.length()-1);
                k--;
            }
            answer.append(c);
        }
        
        return answer.substring(0,answer.length()-k);
        
    }
}