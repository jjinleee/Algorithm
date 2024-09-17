import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> d = new ArrayDeque<>();
        StringBuilder sb= new StringBuilder();


        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int order=Integer.parseInt(st.nextToken());

            if(order==1){
                d.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if(order==2){
                d.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(order==3){
                if(!d.isEmpty()){
                    sb.append(d.pollFirst()+"\n");
                }
                else sb.append(-1+"\n");
            }
            else if(order==4){
                if(!d.isEmpty()){
                    sb.append(d.pollLast()+"\n");
                }
                else sb.append(-1+"\n");
            }
            else if(order==5){
                sb.append(d.size()+"\n");
            }
            else if(order==6){
                if(!d.isEmpty()) sb.append(0+"\n");
                else sb.append(1+"\n");
            }
            else if(order==7){
                if(!d.isEmpty()) sb.append(d.getFirst()+"\n");
                else sb.append(-1+"\n");
            }
            else{
                if(!d.isEmpty()) sb.append(d.getLast()+"\n");
                else sb.append(-1+"\n");
            }
        }

    
        System.out.println(sb.toString());
    }
}