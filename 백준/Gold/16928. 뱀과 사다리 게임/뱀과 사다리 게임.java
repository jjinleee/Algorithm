import java.io.*;
import java.util.*;

public class Main {
    static int m,n;
    static HashMap<Integer,Integer> lad=new HashMap<>();
    static HashMap<Integer,Integer> snake=new HashMap<>();
    static boolean[] visited=new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            lad.put(b,c);
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            snake.put(b,c);
        }


        Queue<int[]> q= new LinkedList<>();
        q.add( new int[]{1,0});
        visited[1]=true;


        while(!q.isEmpty()){
            int[] cur=q.poll();
            int pos=cur[0];
            int cnt=cur[1];

            if(pos>=100){
                System.out.println(cnt);
                return;
            }

            for(int i=1;i<=6;i++){
                int next=pos+i;

                if(lad.containsKey(next)){
                    next=lad.get(next);
                } 
                if(snake.containsKey(next)){
                    next=snake.get(next);
                }


                if(next<=100 && !visited[next]){
                    visited[next]=true;
                    q.offer(new int[]{next,cnt+1});
                }

            }

        }        
       
    }
}