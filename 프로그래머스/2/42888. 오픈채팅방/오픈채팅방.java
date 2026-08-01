import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String> user=new HashMap<>();
        List<String[]> list=new ArrayList<>();
        for(String r : record){
            String[] tmp=r.split(" ");
            String cmd=tmp[0];
            String id=tmp[1];
            String name="";
            
            if(tmp.length>2) {
                name=tmp[2];
            }
            
            if(cmd.equals("Enter")){
                user.put(id,name);
                list.add(new String[]{cmd,id});
            } else if(cmd.equals("Leave")){
                list.add(new String[]{cmd,id});
            } else user.put(id,name);
        }
        
        int n=list.size();
        String[] answer=new String[n];
        for(int i=0;i<n;i++){
            String name=user.get(list.get(i)[1]);
            String cmd=list.get(i)[0];
            if(cmd.equals("Enter")){
                answer[i]=name+"님이 들어왔습니다.";
            } else {
                answer[i]=name+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}