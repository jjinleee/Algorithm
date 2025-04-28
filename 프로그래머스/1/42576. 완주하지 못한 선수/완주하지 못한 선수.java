import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> people=new HashMap<>();
        for(String p:participant){
            people.put(p, people.getOrDefault(p,0)+1);
        }
        
        for(String c:completion){
           int n= people.get(c);
            people.remove(c);
            people.put(c,--n);
        }
        
        for(String a:people.keySet()){
            if(people.get(a)!=0){
                answer=a;
            }
        }
        return answer;
    }
}