import java.util.*;


class Solution {
    
    static List<String> answer;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b)-> a[0].compareTo(b[0])==0 ? a[1].compareTo(b[1]): a[0].compareTo(b[0]));
        
        boolean[] visited= new boolean[tickets.length];

        List<String> w=new ArrayList<>();
        w.add("ICN");
        answer=null;
        dfs("ICN",tickets, visited,w);
        
        
        return answer.toArray(new String[0]);
    }
    static void dfs(String current, String[][] tickets, boolean[] visited, List<String> way){
        if(way.size()==tickets.length+1){
            answer=new ArrayList<>(way);
            return;
        }
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && current.equals(tickets[i][0])){
                if(answer==null){
                    
                
                way.add(tickets[i][1]);
                current=tickets[i][1];
                visited[i]=true;
                dfs(current,tickets, visited, way);
                //백트래킹
                current=tickets[i][0];
                visited[i]=false;
                way.remove(way.size()-1);
            }
            }
        }
    }
}