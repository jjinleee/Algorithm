import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            deque.add(new int[]{i,Integer.parseInt(st.nextToken())});
        }
        

        StringBuilder sb= new StringBuilder();
        int[] curr=deque.poll();
        int next=curr[1];
        sb.append(curr[0]).append(" ");

        while(deque.size()>1){
            if(next>0){
                for(int i=1;i<next;i++){
                    deque.addLast(deque.poll());
                }
                curr=deque.pollFirst();
                sb.append(curr[0]).append(" ");
                next=curr[1];
            } else{
                for(int i=1;i<Math.abs(next);i++){
                    deque.addFirst(deque.pollLast());
                }
                curr=deque.pollLast();
                sb.append(curr[0]).append(" ");
                next=curr[1];
            }
        }

        sb.append(deque.peek()[0]);

        System.out.println(sb.toString());
    }
}