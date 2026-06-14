import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String> member=new HashMap<>();
        List<String[]> list=new ArrayList<>();
        
        for(String r : record){
            String[] tmp=r.split(" ");
            String cmd=tmp[0];
            String id=tmp[1];
            
            if(cmd.equals("Enter") || cmd.equals("Change")){
                String name=tmp[2];

                member.put(id,name);
            } 
            if(!cmd.equals("Change")) list.add(new String[]{id,cmd});
        }
        
        int i=0;
        String[] answer=new String[list.size()];
        for(String[] l : list){
            String id=l[0];
            String cmd=l[1];
            
            if(cmd.equals("Enter")) answer[i++]=member.get(id)+"님이 들어왔습니다.";
            else if(cmd.equals("Leave")) answer[i++]=member.get(id)+"님이 나갔습니다.";
        }
        return answer;
    }
}