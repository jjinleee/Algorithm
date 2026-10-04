import java.util.*;

class Solution {
    class Plan{
        String name;
        int start;
        int playtime;
        
        Plan(String name, int start, int playtime){
            this.name=name;
            this.start=start;
            this.playtime=playtime;
        }
    }
    public String[] solution(String[][] plans) {
        List<String> list=new ArrayList<>();
        int n=plans.length;
        
        List<Plan> p=new ArrayList<>();
        for(String[] plan : plans){
            String name=plan[0];
            int start=toTime(plan[1]);
            int playtime=Integer.parseInt(plan[2]);  
            
            p.add(new Plan(name, start, playtime));
        }
        
        p.sort((a,b)-> Integer.compare(a.start, b.start));
        
        int time=0;
        
        Stack<Plan> stack=new Stack<>();// 중단한 과제
        for(int i=0;i<n-1;i++){
            Plan cur=p.get(i);
            Plan next=p.get(i+1);
            
            int avail=next.start-cur.start;
            
            if(cur.playtime<=avail){ //새로운과제
                list.add(cur.name);
                int remain=avail-cur.playtime;
                
                while(!stack.isEmpty() && remain>0){
                    Plan stopped=stack.pop();
                    
                    if(stopped.playtime<=remain){
                        remain-=stopped.playtime;
                        list.add(stopped.name);
                    } else {
                       stopped.playtime-=remain;
                        stack.push(stopped);
                        remain=0;
                    }
                }
            } else { //중단한과제
                cur.playtime-=avail;
                stack.push(cur);
            }
        }
        
        Plan last=p.get(p.size()-1);
        list.add(last.name);
        
        //남은과제처리
        while(!stack.isEmpty()){
            list.add(stack.pop().name);
        }
        
        return list.toArray(new String[0]);
    }
    int toTime(String time){
        int h=Integer.parseInt(time.split(":")[0]);
        int m=Integer.parseInt(time.split(":")[1]);
        
        return 60*h+m;
    }
}