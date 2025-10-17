import java.util.*;

class Solution {
    static List<String> answer=new ArrayList<>();
    public String[] solution(String[][] tickets) {
        boolean[] visited=new boolean[tickets.length];
        List<String> w=new ArrayList<>();
        
        answer.clear();
        Arrays.sort(tickets, (a,b)-> a[0].compareTo(b[0])==0 ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        w.add("ICN");
        dfs(tickets, visited, "ICN",w);
       
        return answer.toArray(new String[0]);
    }
    static void dfs(String[][] tickets,boolean[] visited,  String current, List<String> way){
        if(way.size()==tickets.length+1) {
            answer=new ArrayList<>(way);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && current.equals(tickets[i][0])){
                if(answer.isEmpty()){
                    visited[i]=true;
                    way.add(tickets[i][1]);
                    dfs(tickets, visited, tickets[i][1], way);    
                    visited[i]=false;
                    way.remove(way.size()-1);
                }

                
            }
        }
    }
}