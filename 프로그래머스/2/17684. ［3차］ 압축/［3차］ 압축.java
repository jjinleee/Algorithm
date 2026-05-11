import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list=new ArrayList<>();
        Map<String, Integer> dict=new HashMap<>();
        for(char c='A';c<='Z';c++){
            dict.put(c+"", c-'A'+1);
        }
        
        int nextidx=27;
        int i=0;
        
        while(i<msg.length()){
            String w="";
            int j=i;
            
            //가장긴 문자열찾기
            while(j<msg.length()){
                String cur=msg.substring(i,j+1);
                
                if(dict.containsKey(cur)){
                    w=cur;
                    j++;
                } else break;
            }
            
            list.add(dict.get(w));
            
            if(j<msg.length()){
                String newWord=msg.substring(i,j+1);
                dict.put(newWord, nextidx++);
            }
            
            i+=w.length();
            
        }        
        
        return list.stream().mapToInt(s->s).toArray();
    }
}