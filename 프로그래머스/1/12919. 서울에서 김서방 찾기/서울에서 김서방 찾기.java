import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        Map<String,Integer> map=new HashMap<>();
        int i=0;
        for(String s : seoul){
            map.put(s,i++);
        }
        return "김서방은 "+map.get("Kim")+"에 있다";
    }
}