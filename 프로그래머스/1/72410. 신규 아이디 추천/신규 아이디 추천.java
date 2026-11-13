import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id=new_id.toLowerCase(); //1단계 : 소문자로치환
        new_id=new_id.replaceAll("[^a-z0-9-_.]",""); //2단계 : 소문자,숫자,-,_,.빼고 제거
        new_id=new_id.replaceAll("\\.{2,}","\\.");//3단계 : .2연속 치환
        new_id=new_id.replaceAll("^\\.|\\.$",""); //4단계 : 처음,끝 . 제거
        if(new_id.isEmpty()) new_id="a"; //5단계 : 빈문자열일시 a
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15).replaceAll("^\\.|\\.$","");//6
        }
        if(new_id.length()<=2){ //7
            char c=new_id.charAt(new_id.length()-1);
            int cnt=3-new_id.length();
            for(int i=0;i<cnt;i++) new_id+=c;
        }
        return new_id;
    }
}