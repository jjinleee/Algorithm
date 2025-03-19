import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        int[] A= new int[n];
        int[] B= new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }

        int m=Integer.parseInt(br.readLine());
        int[] C= new int[m];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            C[i]=Integer.parseInt(st.nextToken());
        }

        Deque<Integer> d=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(A[i]==0) d.add(B[i]);
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<m;i++){
            d.offerFirst(C[i]);
            sb.append(d.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}