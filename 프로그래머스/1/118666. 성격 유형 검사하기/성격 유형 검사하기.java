import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb= new StringBuilder();
        
        //성격유형 저장(array로?->순서변경감지어떻게)
        Map<Character,Integer> personal=new HashMap<>();
        for (char c :"RTCFJMAN".toCharArray()){
            personal.put(c,0);
        }
        
        for(int i=0;i<survey.length;i++){
            char left=survey[i].charAt(0);
            char right=survey[i].charAt(1);
            int choice=choices[i];
            
            if(choice<4) personal.put(left, personal.get(left)+(4-choice));
            else if(choice>4) personal.put(right, personal.get(right)+(choice-4));
        }
        
        sb.append(personal.get('R')>=personal.get('T')? 'R' : 'T');
        sb.append(personal.get('C') >= personal.get('F') ? 'C' : 'F');
        sb.append(personal.get('J') >= personal.get('M') ? 'J' : 'M');
        sb.append(personal.get('A') >= personal.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}