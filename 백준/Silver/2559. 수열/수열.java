import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        //i번까지의합을 담는 배열
        int[] prefix= new int[n+1];

        
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+Integer.parseInt(st.nextToken());
        }


        int max=Integer.MIN_VALUE;

        for(int i=1;i<=n-k+1;i++){
            int temp=prefix[i+k-1]-prefix[i-1];
            max=Math.max(max, temp);
        }

        System.out.println(max);


    }
}