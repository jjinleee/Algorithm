import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb= new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0) {
                if(pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
            else pq.add(num);
        }

        System.out.println(sb);
    }
}