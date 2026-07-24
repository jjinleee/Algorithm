import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {
        Map<String,String> map=new HashMap<>();
        List<String[]> list=new ArrayList<>();
        
        for(String r : record){
            String[] tmp=r.split(" ");
            String cmd=tmp[0];
            String uid=tmp[1];
            
            if(cmd.equals("Leave")){
                list.add(new String[]{"Leave",uid});
                continue;
            }
            String name=tmp[2];
            
            if(cmd.equals("Enter")){
                list.add(new String[]{"Enter",uid});
            } 
            map.put(uid, name);
        }
        
        String[] answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
            String[] tmp=list.get(i);
            String user=map.get(tmp[1]);
            if(tmp[0].equals("Enter")) answer[i]=user+"님이 들어왔습니다.";
            else answer[i]=user+"님이 나갔습니다.";
        }
        
        return answer;
    }
}