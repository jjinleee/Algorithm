import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String[]> list= new ArrayList<>();
        Map<String,String> id=new HashMap<>();
        
        for(String r : record){
            String[] tmp=r.split(" ");
            String cmd=tmp[0];
            String uid=tmp[1];
            
            if(cmd.equals("Enter")||cmd.equals("Change")){
                String name=tmp[2];
                id.put(uid,name);
            } 
            if(!cmd.equals("Change")) list.add(new String[]{uid,cmd});
        }
        String[] result=new String[list.size()];
        int i=0;
        for(String[] s : list){
            String idx=s[0];
            String cmd=s[1];
            
            if(cmd.equals("Enter")) result[i++]=id.get(idx)+"님이 들어왔습니다.";
            else if(cmd.equals("Leave")) result[i++]=id.get(idx)+"님이 나갔습니다.";
        }
        
        return result;
    }
}