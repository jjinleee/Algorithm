import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        //i번까지의합을 담는 배열
        int[] prefix= new int[n+1];

        
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+Integer.parseInt(st.nextToken());
        }

        StringBuilder sb= new StringBuilder();
        for(int k=0;k<m;k++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            sb.append(prefix[end]-prefix[start-1]).append("\n");
        }

        System.out.println(sb.toString());


    }
}