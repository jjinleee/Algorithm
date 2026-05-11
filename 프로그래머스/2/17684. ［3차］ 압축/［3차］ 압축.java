import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list= new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        
        for(char c ='A';c<='Z';c++){
            map.put(c+"", c-64);
        }
        
        int last=27;
        int i=0;
        
        while(i<msg.length()){
            String w="";
            int j=i;
            
            while(j<msg.length()){
                String cur=msg.substring(i,j+1);
                
                if(map.containsKey(cur)){
                    j++;
                    w=cur;
                } else break;
            }
            
            list.add(map.get(w));
            
            if(j<msg.length()){
                map.put(msg.substring(i,j+1),last++);
            }
            
            i+=w.length();
            
        }
        return list.stream().mapToInt(s->s).toArray();
    }
}