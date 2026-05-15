import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String tmp=s.replaceAll("[^0-9]","");
        if(tmp.equals(s)) return Integer.parseInt(s);
        
        Map<String, Integer> map=new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        
        for(String n : map.keySet()){
            if(s.contains(n)){
                s=s.replace(n,String.valueOf(map.get(n)));
            }
        }
        
        return Integer.parseInt(s);
    }
}