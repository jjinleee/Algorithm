import java.util.*;

class Solution {
    static List<String> list=new ArrayList<>();
    static List<String> answer;
    static boolean finished;
    public String[] solution(String[][] tickets) {
        boolean[] visited=new boolean[tickets.length];
        
        //티켓 알파벳순정렬
        Arrays.sort(tickets, (a,b)-> a[1]==b[1] ? a[0].compareTo(b[0]) : a[1].compareTo(b[1]));
        
        list.add("ICN");
        dfs("ICN",tickets, visited);
        
        return answer.toArray(new String[0]);
    }
    static void dfs(String current, String[][] tickets, boolean[] visited){
        if(list.size()==tickets.length+1){
            finished=true;
            answer=new ArrayList<>(list);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(current) && !visited[i]){
                list.add(tickets[i][1]);
                visited[i]=true;
                dfs(tickets[i][1], tickets, visited);
                
                //답 찾았으면 바로 종료
                if(finished) return;
                //백트래킹
                visited[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}