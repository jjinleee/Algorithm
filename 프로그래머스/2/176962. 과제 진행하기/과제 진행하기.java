import java.util.*;

class Solution {
    class Work{
        String name;
        int start;
        int remain;
        
        Work(String name, int start, int remain){
            this.name=name;
            this.start=start;
            this.remain=remain;
        }
    }
    public String[] solution(String[][] plans) {
        List<String> list= new ArrayList<>();
        
        List<Work> plan= new ArrayList<>();
        for(String[] p : plans){
            String[] tmp=p[1].split(":");
            int time=60*Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1]);
            plan.add(new Work(p[0],time,Integer.parseInt(p[2])));
        }
        plan.sort((a,b)->Integer.compare(a.start,b.start));
        
        Stack<Work> stop=new Stack<>();
        
        for(int i=0;i<plan.size()-1;i++){
            Work cur=plan.get(i);
            Work next=plan.get(i+1);
            
            int available=next.start-cur.start;
            
            if(cur.remain<=available){ //완료
                list.add(cur.name);
                int left=available-cur.remain;
                while(!stop.isEmpty()&& left>0){
                    Work stopped=stop.pop();
                    
                    if(stopped.remain<=left){ //중단된과제끝냄
                        left-=stopped.remain;
                        list.add(stopped.name);
                    } else{ //중단된과제 못끝냄
                        stopped.remain-=left;
                        stop.push(stopped);
                        left=0;
                    }
                }
            } else {
                cur.remain-=available;
                stop.push(cur);
            }
            
        }
        
        Work last=plan.get(plan.size()-1);
        list.add(last.name);
        
        while(!stop.isEmpty()){
            list.add(stop.pop().name);
        }
        
        return list.toArray(new String[0]);
    }
}