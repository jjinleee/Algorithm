import java.io.*;
import java.lang.invoke.StringConcatFactory;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] dist=new long[n-1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++){
            dist[i]=Integer.parseInt(st.nextToken());
        }

        long[] cost=new long[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cost[i]=Integer.parseInt(st.nextToken());
        }
        
        long total=0;
        long min=cost[0];

        for(int i=0;i<n-1;i++){
            total+=min*dist[i];
            if(cost[i+1]<min){
                min=cost[i+1];
            }
        }

        System.out.println(total);

       
    }
}