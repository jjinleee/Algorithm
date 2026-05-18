import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        
        List<String> l1=new ArrayList<>();
        List<String> l2=new ArrayList<>();
        Map<String,Integer> m1=new HashMap<>();
        Map<String,Integer> m2=new HashMap<>();
        
        for(int i=0;i<str1.length()-1;i++){
            String tmp=str1.substring(i,i+2);
            if(tmp.matches("[a-z]{2}")) {
                m1.put(tmp, m1.getOrDefault(tmp,0)+1);
                l1.add(tmp);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            String tmp=str2.substring(i,i+2);
            if(tmp.matches("[a-z]{2}")) {
                m2.put(tmp, m2.getOrDefault(tmp,0)+1);
                l2.add(tmp);
            }
        }
        
        
        int com=0;
        for(String m : m1.keySet()){
            if(m2.containsKey(m)) com+=Math.min(m1.get(m),m2.get(m));
        }
        int sum=l1.size()+l2.size()-com;
        
        if(com==0 && sum==0) return 65536;
        
        
        return (int) ((double)com/sum*65536);
    }
}